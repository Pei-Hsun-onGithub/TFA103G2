<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

	<!-- popper 函式庫  -->
	<script src="https://unpkg.com/@popperjs/core@^2.0.0"></script>
	<script>
		/*********************  Popover 函式庫 相關設定  ********************************************/

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

		/*********************  設定小鈴鐺的按鈕切換handler  ********************************************/
		function toggleTheTooltip() {
			$('#tooltip').toggle();
		}
	</script>