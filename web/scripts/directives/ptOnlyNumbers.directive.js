'use strict'

angular.module('petshopinterview')
  .directive('psOnlyNumbers', function () {
    return  {
      restrict: 'A',
      link: function (scope, elm, attrs, ctrl) {
        elm.on('keydown', function (event) {
            if(event.shiftKey){event.preventDefault(); return false;}
            if ([8, 13, 27, 37, 38, 39, 40].indexOf(event.which) > -1) {
              // backspace, enter, escape, arrows
              return true;
            } else if (event.which >= 48 && event.which <= 57) {
              // numbers 0 to 9
              return true;
            } else if (event.which >= 96 && event.which <= 105) {
              // numpad number
              return true;
            }
            else {
              event.preventDefault();
              return false;
            }
        });
      }
    }
});