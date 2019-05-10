(function($) {
    "use strict";

    // responsive-menu tigger
    $(".responsive-menu-tigger li").on("click", function() {
        $(".responsive-menu-area,.responsive-menu-tigger").toggleClass("active");
    });

    // search-area
    $(".search-tigger a").on('click', function() {
        $(".search-area").addClass("active");
    });

    // search-area
    $(".close-btn").on('click', function() {
        $(".search-area").removeClass("active");
    });

    $('ul.metismenu').metisMenu({});

    // responsive-menu tigger
    $(".menu").on('click', function() {
        $(".manu-sidebar-area,.menu").toggleClass("active");
    });

    $('.gallary-item').bind({
        mouseenter: function(e) {
            $(this).addClass('active');
            $(this).siblings().addClass('inactive');
        },
        mouseleave: function(e) {
            $(this).removeClass('active');
            $(this).siblings().removeClass('inactive');
        }
    });

    // slider-active
    $('.slider-active').owlCarousel({
        margin: 0,
        loop: true,
        nav: false,
        smartSpeed: 1200,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        responsive: {
            0: {
                items: 1,
            },
            450: {
                items: 1,
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    });

    // slider-active
    $('.slider-active2').owlCarousel({
        margin: 0,
        loop: true,
        nav: true,
        smartSpeed: 1200,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        responsive: {
            0: {
                items: 1,
            },
            450: {
                items: 1,
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    });



    // slider-active
    $(".slider-active").on('translate.owl.carousel', function() {
        $('.slider-items h2').removeClass('slideInUp animated').hide();
        $('.slider-items p').removeClass('slideInUp animated').hide();
        $('.slider-items ul').removeClass('slideInUp animated').hide();
    });

    $(".slider-active").on('translated.owl.carousel', function() {
        $('.owl-item.active .slider-items h2').addClass('slideInUp animated').show();
        $('.owl-item.active .slider-items p').addClass('slideInUp animated').show();
        $('.owl-item.active .slider-items ul').addClass('slideInUp animated').show();
    });




    //slider-area background setting
    function sliderBgSetting() {
        if ($(".slider-active .slider-items,.slider-active2 .slider-items").length) {
            $(".slider-active .slider-items,.slider-active2 .slider-items").each(function() {
                var $this = $(this);
                var img = $this.find(".slider").attr("src");

                $this.css({
                    backgroundImage: "url(" + img + ")",
                    backgroundSize: "cover",
                    backgroundPosition: "center center"
                })
            });
        }
    }
    sliderBgSetting()

    // masonry effect
    $('.grid').imagesLoaded(function() {
        var $grid = $('.grid').isotope({
            itemSelector: '.items',
            percentPosition: true,
            masonry: {
                columnWidth: '.items',
            }
        });
    });
    
    // slider-active
    $('.service-active').owlCarousel({
        margin: 30,
        loop: true,
        nav: false,
        smartSpeed: 1200,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        URLhashListener: true,
        startPosition: 'URLHash',
        responsive: {
            0: {
                items: 1,
            },
            450: {
                items: 2,
            },
            768: {
                items: 2
            },
            1000: {
                items: 3
            },
            1200: {
                items: 3
            }
        }
    });

    // slider-active
    $('.test-active').owlCarousel({
        margin: 30,
        loop: true,
        nav: false,
        smartSpeed: 1200,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        URLhashListener: true,
        startPosition: 'URLHash',
        responsive: {
            0: {
                items: 1
            },
            450: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            },
            1200: {
                items: 1
            }
        }
    });


    // slider-active
    $('.brand-active').owlCarousel({
        margin: 15,
        loop: true,
        nav: false,
        smartSpeed: 1200,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        URLhashListener: true,
        startPosition: 'URLHash',
        responsive: {
            0: {
                items: 2
            },
            450: {
                items: 3
            },
            768: {
                items: 4
            },
            1000: {
                items: 5
            },
            1200: {
                items: 6
            }
        }
    });


    // // stickey menu
    $(window).on('scroll', function() {
        var scroll = $(window).scrollTop(),
            mainHeader = $('#sticky-header'),
            mainHeaderHeight = mainHeader.innerHeight();

        // console.log(mainHeader.innerHeight());
        if (scroll > 89) {
            $("#sticky-header").addClass("sticky");
        } else {
            $("#sticky-header").removeClass("sticky");
        }
    });

    /*--------------------------
     scrollUp
    ---------------------------- */
    // declare variable
    var scrollTop = $(".scrollup");

    //Click event to scroll to top
    $(scrollTop).on('click', function() {
        $('html, body').animate({
            scrollTop: 0
        }, 900);
        return true;

    }); // click() scroll top EMD


    $('.counter').counterUp({
        delay: 10,
        time: 1000
    });

    /*--
    Magnific Popup
    ------------------------*/
    $('.popup').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }

    });
    // popup video
    $('.video-popup').magnificPopup({
        type: 'iframe',
        gallery: {
            enabled: true
        }
    })

    // Parallax background
    function bgParallax() {
        if ($(".parallax").length) {
            $(".parallax").each(function() {
                var height = $(this).position().top;
                var resize = height - $(window).scrollTop();
                var parallaxSpeed = $(this).data("speed");
                var doParallax = -(resize / parallaxSpeed);
                var positionValue = doParallax + "px";
                var img = $(this).data("bg-image");

                $(this).css({
                    backgroundImage: "url(" + img + ")",
                    backgroundPosition: "50%" + positionValue,
                    backgroundSize: "cover",
                    backgroundRepeat: "no-repeat",
                });

                if (window.innerWidth < 768) {
                    $(this).css({
                        backgroundPosition: "center center"
                    });
                }
            });
        }
    }
    bgParallax();




    /*---------------------
     countdown
    --------------------- */
    $('[data-countdown]').each(function() {
        var $this = $(this),
            finalDate = $(this).data('countdown');
        $this.countdown(finalDate, function(event) {
            $this.html(event.strftime('<span class="cdown days"><span class="time-count">%-D</span> <p>Days</p></span> <span class="cdown hour"><span class="time-count">%-H</span> <p>Hour</p></span> <span class="cdown minutes"><span class="time-count">%M</span> <p>Miniute</p></span> <span class="cdown second"> <span><span class="time-count">%S</span> <p>Second</p></span>'));
        });
    });

    /*====================================================
                    load-function
    ====================================================*/

    $(window).on('load', function() {
        /*-- preloader ---*/
        $('.preloade-wrap').fadeOut();
    });



    $(window).on("scroll", function() {
        /*-- preloader ---*/
        $('.preloade-wrap').fadeOut();

        bgParallax();
    });


    /*---------------------
    // Ajax Contact Form
    --------------------- */

    $('.cf-msg').hide();
    $('form#cf button#submit').on('click', function() {
        var fname = $('#fname').val();
        var subject = $('#subject').val();
        var email = $('#email').val();
        var msg = $('#msg').val();
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (!regex.test(email)) {
            alert('Please enter valid email');
            return false;
        }

        fname = $.trim(fname);
        subject = $.trim(subject);
        email = $.trim(email);
        msg = $.trim(msg);

        if (fname != '' && email != '' && msg != '') {
            var values = "fname=" + fname + "&subject=" + subject + "&email=" + email + " &msg=" + msg;
            $.ajax({
                type: "POST",
                url: "mail.php",
                data: values,
                success: function() {
                    $('#fname').val('');
                    $('#subject').val('');
                    $('#email').val('');
                    $('#msg').val('');

                    $('.cf-msg').fadeIn().html('<div class="alert alert-success"><strong>Success!</strong> Email has been sent successfully.</div>');
                    setTimeout(function() {
                        $('.cf-msg').fadeOut('slow');
                    }, 4000);
                }
            });
        } else {
            $('.cf-msg').fadeIn().html('<div class="alert alert-danger"><strong>Warning!</strong> Please fillup the informations correctly.</div>')
        }
        return false;
    });

})(jQuery);