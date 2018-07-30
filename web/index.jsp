<!DOCTYPE html>
<html ng-app="petshopinterview">
  <head>
    <meta charset="utf-8">
    <title>Petshop application</title>
    <link rel="stylesheet" type="text/css" href="main.css"/>
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material-icons/angular-material-icons.css"/>
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/angular-material.css" />
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/layouts/angular-material.layouts.min.css" />
    <link rel="shortcut icon" href="https://www.petshop.ru/favicon.ico" />
    <script type="text/javascript" src="/bower_components/angular/angular.js"></script>
    <script type="text/javascript" src="/bower_components/angular-resource/angular-resource.js"></script>
    <script type="text/javascript" src="/bower_components/angular-aria/angular-aria.js"></script>
    <script type="text/javascript" src="/bower_components/angular-animate/angular-animate.js"></script>
    <script type="text/javascript" src="/bower_components/angular-messages/angular-messages.js"></script>
    <script type="text/javascript" src="/bower_components/angular-material/angular-material.js"></script>
    <script type="text/javascript" src="/bower_components/angular-material-icons/angular-material-icons.min.js"></script>
    <script type="text/javascript" src="/bower_components/angular-ui-router/release/angular-ui-router.js"></script>
    <!-- Configuration -->
    <script type="text/javascript" src="/scripts/petshop.modules.js"></script>
    <script type="text/javascript" src="/scripts/petshop.states.js"></script>
    <!-- Controllers -->
    <script type="text/javascript" src="/scripts/controllers/animal.controller.js"></script>
    <script type="text/javascript" src="/scripts/controllers/owner.controller.js"></script>
    <script type="text/javascript" src="/scripts/controllers/pet.controller.js"></script>
    <!-- Services -->
    <script type="text/javascript" src="/scripts/services/animal.service.js"></script>
    <script type="text/javascript" src="/scripts/services/owner.service.js"></script>
    <script type="text/javascript" src="/scripts/services/pet.service.js"></script>
    <!-- Directives -->
    <script type="text/javascript" src="/scripts/directives/ptOnlyNumbers.directive.js"></script>
  </head>
  <body>
    <a ui-sref="AnimalState"> Animal table </a>
    <a ui-sref="OwnerState"> Owner table </a>
    <a ui-sref="PetState"> OwnerAnimal table </a>
    <ui-view></ui-view>
  </body>
</html>