<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

	<!-- popper �禡�w  -->
	<script src="https://unpkg.com/@popperjs/core@^2.0.0"></script>
	<script>
		/*********************  Popover �禡�w �����]�w  ********************************************/

		const bell = document.querySelector('#my-bell');
		const tooltip = document.querySelector('#tooltip');

		// Pass the button, the tooltip, and some options, and Popper will do the
		// magic positioning for you:
		Popper.createPopper(bell, tooltip, {
			placement : 'bottom',
			modifiers : [ {
				name : 'offset',
				options : {
					offset : [ 0, 10 ],
				},
			}, ],

		});

		/*********************  �]�w�p�a�L�����s����handler  ********************************************/
		function toggleTheTooltip() {
			$('#tooltip').toggle();
		}
	</script>