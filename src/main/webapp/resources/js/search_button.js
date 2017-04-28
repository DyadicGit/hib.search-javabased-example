/**
 * Created by OlgerdSe on 2017-03-07.
 */
$(function () {
    /**
     * the element
     */
    var $ui = $('#ui_element');

    /**
     * on focus and on click display the dropdown,
     * and change the arrow image
     */
    $ui.find('.sb_input').bind('focus click', function () {
        $ui.find('.sb_down')
            .addClass('sb_up')
            .removeClass('sb_down')
            .andSelf()
            .find('.sb_dropdown')
            .show();
    });

    /**
     * on mouse leave hide the dropdown,
     * and change the arrow image
     */
    $ui.bind('mouseleave', function () {
        $ui.find('.sb_up')
            .addClass('sb_down')
            .removeClass('sb_up')
            .andSelf()
            .find('.sb_dropdown')
            .hide();
    });

});