module.exports = function (grunt) {
    require('time-grunt')(grunt);
    // These plugins provide necessary tasks.
    require('load-grunt-tasks')(grunt);
    // Project configuration.
    grunt.initConfig({
        // Metadata.
        pkg: grunt.file.readJSON('package.json'),
        clean: ['dist/'],
        less: {
            compileCore: {
                options: {
                    strictMath: true,
                    sourceMap: true,
                    outputSourceFiles: true,
                    sourceMapURL: 'bootstrap.css.map',
                    sourceMapFilename: 'dist/css/bootstrap.css.map'
                },
                src: 'libs/bootstrap/less/bootstrap.less',
                dest: 'dist/css/bootstrap.css'
            },
            compileTheme: {
                options: {
                    strictMath: true,
                    sourceMap: true,
                    outputSourceFiles: true,
                    sourceMapURL: 'bootstrap-theme.css.map',
                    sourceMapFilename: 'dist/css/bootstrap-theme.css.map'
                },
                src: 'libs/bootstrap/less/theme.less',
                dest: 'dist/css/bootstrap-theme.css'
            }
        },
        concat: {
            options: {
                banner: '/**<%=pkg.banner%>**/\n',
                separator: '\n', //合并后，两个文件之间的分隔符
                stripBanners: true
            },
            dist: {
                src: ['src/css/**/*.css'],
                dest: 'dist/<%=pkg.name%>.css'
            }
        },
        connect: {
            server:{
                options: {
                    port: 80,
                    keepalive: true,
                    hostname: '*',
                    base: {
                        path: '.',
                        options:{

                        }
                    }
                }
            }
        },
        copy : {
            main : {
                files : [
                    {expand: true, src: ['css/*.css'], dest: '<%=pkg.copyTarget%>'},
                    {expand: true, src: ['dist/**/*'], dest: '<%=pkg.copyTarget%>'},
                    {expand: true, src: ['img/**'], dest: '<%=pkg.copyTarget%>'},
                    {expand: true, src: ['js/app/plugins/**/*'], dest: '<%=pkg.copyTarget%>'},
                    {expand: true, src: ['js/app/**/*.js'], dest: '<%=pkg.copyTarget%>'},
                    {expand: true, src: ['libs/**/*'], dest: '<%=pkg.copyTarget%>'},
                ]
            }
        },
        csslint: {
            //"rules": "node -e "require('csslint').CSSLint.getRules().forEach(function(x) { console.log('\"' + x.id + '\": true,') })"
            options: {
                csslintrc: '.csshintrc', //Loading rules from an external file
                formatters: [
                    {id: 'checkstyle-xml', dest: 'dist/csslint.xml'}, //把检查结果放在报告文档内。
                    {id: 'compact', dest: 'dist/compact.txt'} //把检查结果放在报告文档内。
                ]
            },
            strict: {
                options: {
                    import: 2
                },
                src: ['css/**/*.css', 'js/app/plugins/**/*.css'] //检查的css文件路径。
            }
        },
        cssmin: {
            combine: {
                files: {
                    '<%=pkg.distination%>/<%= pkg.name %>.min.css': ['<%=concat.dist.dest%>']
                }
            },
            options:{
                report: 'gzip',
                sourceMap: true
            }
        },
        htmlmin : { // Task
            dist : { // 目标
                options : { // 目标操作
                    // 去除注释
                    removeComments : true,
                    // 去除换行空格
                    collapseWhitespace : true
                },
                files: [{ //Dictionary of files
                    expand: true,
                    src: '../templates/**/*.html' // Source
                    //dest: '<%=pkg.distination%>/html' // Destination
                }]
            }
        },
        imagemin : {
            /* 压缩图片大小 */
            dist : {
                options : {
                    // 定义 PNG 图片优化水平
                    optimizationLevel : 5
                },
                files : [ {
                    expand : true,
                    cwd : 'img/',
                    src : [ '**/*.{png,jpg,jpeg}' ], // 优化 img 目录下所有png/jpg/jpeg 图片
                    dest : '<%=pkg.distination%>/img/' // 优化后的图片保存位置，覆盖旧图片，并且不作提示
                } ]
            }
        },
        jshint : {
            options : {
                jshintrc: true,
                reporter: require('jshint-stylish'),
                reporterOutput: 'dist/jshint.txt'
            },
            uses_defaults : [ 'js/**/*.js' ],
            beforeconcat: [],
            afterconcat: []
        },
		uglify : {
            options : {
                banner : '/* All right reserved by JIM Co. Ltd. <%= grunt.template.today("yyyy-mm-dd HH:mm:ss") %> */\n',
				mangle: {
					except: ['jQuery']
				},
				report: 'gzip',
                compress : true,
				ASCIIOnly: true,
                //beautify : true,
                sourceMap: false,
                sourceMapName: 'dist/report.map'
            },
            // 此处定义源文件assets/js/下，所有的JS文件和目标文件build/下的<%=
            // pkg.name%>.min.js
            build : {
				// src : [
    //                 'pages/testcase/caseDesign/caseedit-parameters.js',
    //                 'pages/testcase/caseDesign/caseedit-event.js',
    //                 'pages/testcase/caseDesign/caseedit-rpc.js',
    //                 'pages/testcase/caseDesign/caseedit.js',
    //                 'pages/testcase/sqlConfig/sqlConfig.js',
    //                 'pages/testcase/sqlConfig/sqlConfig-rpc.js',
    //                 'pages/testcase/paramManage/param-rpc.js'

    //             ],
    //             dest : 'dist/caseDesign-caseedit.min.js'

                src : [
                    'js/jquery.imgareaselect.js',
                    'pages/testcase/caseDesignMobile/case-rpc.js',
                    'pages/testcase/caseDesignMobile/case.js',
                    'pages/testcase/caseDesignMobile/appcaseedit.js',
                    'pages/execute/sceneExec-rpc.js',
                    'pages/testcase/caseDesignMobile/appsceneexec.js',
                    'pages/execute/mobileResult/mobileResult-rpc.js',
                    'pages/execute/mobileResult/mobileResult.js',
                    'pages/config/projectStructure/projectStructure-rpc.js',
                    'pages/testcase/scenedesign/scene-rpc.js'

                ],
                dest : 'dist/caseDesignMobile-appcaseedit.min.js'
            }
        },
        watch: {
            livereload: {
                options: {
                    spawn: false
                },
                tasks: ['jshint', 'htmlhint', 'csslint'],
                files: [  //下面文件的改变就会实时刷新网页
                    'html/**/*.html',
                    'css/**/*.css',
                    'js/**/*.js',
                    'img/**/*.{png,jpg,gif,jpeg,ico}'
                ]
            }
        },
        htmlhint: {
            options: {
                htmlhintrc: '.htmlhintrc'
            },
            html1: {
                src: ['html/**/*.html']
            }
        },
        html2js: {
            options: {
                // custom options, see below
            },
            main: {
                src: ['template/**/*.hbs'],
                dest: 'dist/templates.js'
            }
        },
        css_sprite: {
            options: {
                'cssPath': 'css/',
                'processor': 'css',
                'orientation': 'vertical',
                'margin': 4
            },
            sprite: {
                options: {
                    'style': 'dest/css/sprite.css'
                },
                src: ['img/**/*'],
                dest: 'dest/img/sprite.png'
            }
        }
    });

    // Default task.
    grunt.registerTask('js', ['uglify']);
    grunt.registerTask('css', ['concat', 'cssmin']);
    grunt.registerTask('default', ['js']);
};