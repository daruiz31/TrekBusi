$(document).ready(main);

	var contador = 1;

	function main() {
		// body...
		$('.icon-menu').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('nav').animate({
					left:'0'
				});
				contador = 0;
			}
			else{
				contador = 1;
				$('nav').animate({
					left:'-100%'
				});
			}

			
		});
		$('.link-header').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('nav').animate({
					left:'0'
				});
				contador = 0;
			}
			else{
				contador = 1;
				$('nav').animate({
					left:'-100%'
				});
			}

			
		});

		$('.somos-link').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('nav').animate({
					left:'0'
				});
				contador = 0;
			}
			else{
				contador = 1;
				$('nav').animate({
					left:'-100%'
				});
			}

			
		});
		$('.section-services').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('nav').animate({
					left:'0'
				});
				contador = 0;
			}
			else{
				contador = 1;
				$('nav').animate({
					left:'-100%'
				});
			}

			
		});
		$('.link-products').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('nav').animate({
					left:'0'
				});
				contador = 0;
			}
			else{
				contador = 1;
				$('nav').animate({
					left:'-100%'
				});
			}

			
		});

		$('.fa').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('#admin-menu').animate({
					left:'0'

				});
				contador = 0;
			}
			else{
				contador = 1;
				$('#admin-menu').animate({
					left:'-100%'
				});
			}

			
		});
		$('.padre-menu').click(function(){
			//$('nav').toggle();
			if (contador == 1){
				$('.hijo-menu').animate({
					right:'0'

				});
				contador = 0;
			}
			else{
				contador = 1;
				$('.hijo-menu').animate({
					right:'-100%'
				});
			}

			
		});

	}


$(function(){

     $('a[href=#header]').click(function() {

     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
         && location.hostname == this.hostname) {

             var $target = $(this.hash);

             $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');

             if ($target.length) {

                 var targetOffset = $target.offset().top;

                 $('html,body').animate({scrollTop: targetOffset}, 1000);

                 return false;

            }

       }

   });

});
$(function(){

     $('a[href=#somos]').click(function() {

     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
         && location.hostname == this.hostname) {

             var $target = $(this.hash);

             $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');

             if ($target.length) {

                 var targetOffset = $target.offset().top;

                 $('html,body').animate({scrollTop: targetOffset}, 1000);

                 return false;

            }

       }

   });

});
$(function(){

     $('a[href=#services]').click(function() {

     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
         && location.hostname == this.hostname) {

             var $target = $(this.hash);

             $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');

             if ($target.length) {

                 var targetOffset = $target.offset().top;

                 $('html,body').animate({scrollTop: targetOffset}, 1000);

                 return false;

            }

       }

   });

});
$(function(){

     $('a[href=#products]').click(function() {

     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
         && location.hostname == this.hostname) {

             var $target = $(this.hash);

             $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');

             if ($target.length) {

                 var targetOffset = $target.offset().top;

                 $('html,body').animate({scrollTop: targetOffset}, 1000);

                 return false;

            }

       }

   });

});
