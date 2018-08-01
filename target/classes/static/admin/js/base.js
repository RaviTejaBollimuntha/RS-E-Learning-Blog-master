/**
 *  Tale global function object var tale = new $.tale();
 */
$.extend({
    tale: function () {
    }
});

/**
 * tale alert Delete // todo: reduce coupling, chain operation instead 2017-02-27
 * @param options
 */
// $.tale.prototype.alert_del = function (options) {
//     swal({
//         title: options.title || 'Warning message',
//         text: options.text || "confirm to delete?",
//         type: 'warning',
//         showCancelButton: true,
//         confirmButtonColor: '#3085d6',
//         cancelButtonColor: '#d33',
//         confirmButtonText: 'OK',
//         cancelButtonText: 'cancel'
//     }).then(function () {
//         $.post(options.url, options.parame, function (result) {
//             if (result && result.success) {
//                 swal('Prompt message', 'successfully deleted', 'success');
//                 setTimeout(function () {
//                     window.location.reload();
//                 }, 2000);
//             } else {
//                 swal("Prompt message", result.msg, 'error');
//             }
//         });
//     }).catch(swal.noop);
// };

/**
 * Successful frame
 * @param options
 */
$.tale.prototype.alertOk = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || 'Successful operation';
    options.text = options.text;
    options.showCancelButton = false;
    options.showCloseButton = false;
    options.type = 'success';
    this.alertBox(options);
};

/**
 * Pop up successfully and refresh the page after 500 milliseconds
 * @param text
 */
$.tale.prototype.alertOkAndReload = function (text) {
    this.alertOk({text:text, then:function () {
        setTimeout(function () {
            window.location.reload();
        }, 500);
    }});
};

/**
 * 
 * @param options
 */
$.tale.prototype.alertWarn = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || 'Warning message';
    options.text = options.text;
    options.timer = 3000;
    options.type = 'warning';
    this.alertBox(options);
};

/**
 * Ask the confirmation box, here will pass the then function to come in
 * @param options
 */
$.tale.prototype.alertConfirm = function (options) {
    options = options || {};
    options.title = options.title || 'You sure you want to delete it?';
    options.text = options.text;
    options.showCancelButton = true;
    options.type = 'question';
    this.alertBox(options);
};

/**
 * Error message
 * @param options
 */
$.tale.prototype.alertError = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || 'Error message';
    options.text = options.text;
    options.type = 'error';
    this.alertBox(options);
};

/**
 * Public bullet box
 * @param options
 */
$.tale.prototype.alertBox = function (options) {
    swal({
        title: options.title,
        text: options.text,
        type: options.type,
        timer: options.timer || 9999,
        showCloseButton: options.showCloseButton,
        showCancelButton: options.showCancelButton,
        showLoaderOnConfirm: options.showLoaderOnConfirm || false,
        confirmButtonColor: options.confirmButtonColor || '#3085d6',
        cancelButtonColor: options.cancelButtonColor || '#d33',
        confirmButtonText: options.confirmButtonText || 'Ok',
        cancelButtonText: options.cancelButtonText || 'cancel'
    }).then(function (e) {
        options.then && options.then(e);
    }).catch(swal.noop);
};

/**
 * Global post function
 *
 * @param options   parameter
 */
$.tale.prototype.post = function (options) {
    var self = this;
    $.ajax({
        type: 'POST',
        url: options.url,
        data: options.data || {},
        async: options.async || false,
        dataType: 'json',
        success: function (result) {
            self.hideLoading();
            options.success && options.success(result);
        },
        error: function () {
            //
        }
    });
};

/**
 * Display animation
 */
$.tale.prototype.showLoading = function () {
    if ($('#tale-loading').length == 0) {
        $('body').append('<div id="tale-loading"></div>');
    }
    $('#tale-loading').show();
};

/**
 * Hidden animation
 */
$.tale.prototype.hideLoading = function () {
    $('#tale-loading') && $('#tale-loading').hide();
};