# AndroidVIP

Android project to experiment the [VIPER approach](https://www.objc.io/issues/13-architecture/viper/).

[![Dependency Status](https://www.versioneye.com/user/projects/58fe705d6ac171431cf950fc/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/58fe705d6ac171431cf950fc)

## Motivations

- Tend toward the [VIPER approach](https://www.objc.io/issues/13-architecture/viper/)
- Make it easier to test the application
- Simplify the set up of asynchronous job with [RxJava](https://github.com/ReactiveX/RxJava)

## Technical base

- [mosby](https://github.com/sockeqwe/mosby) to set up the "V" and "P" of  the [VIPER approach](https://www.objc.io/issues/13-architecture/viper/)
- [dagger2](https://google.github.io/dagger/) to set up the dependency injection system
- [Rx.Observe](https://github.com/florent37/Rx.Observe) to ease the set up of asynchronous job, transforming Interactor's methods to Rx methods 
- [DaggerMock](https://github.com/fabioCollini/DaggerMock) to mock dagger2 objects
- [mockito](http://site.mockito.org/) as a mocking framework

## Perspectives

- use of [bluelinelabs' Conductor library](https://github.com/bluelinelabs/Conductor) to build View-based application:
    - to manage the "V" of the [VIPER approach](https://www.objc.io/issues/13-architecture/viper/)
    - to provide the "R" of the [VIPER approach](https://www.objc.io/issues/13-architecture/viper/) (via the `Router` class)
- set up the "E" of the  [VIPER approach](https://www.objc.io/issues/13-architecture/viper/) 
    - use of a [ContentProvider](https://developer.android.com/reference/android/content/ContentProvider.html)
        - a combination of [ProviGen](https://github.com/TimotheeJeannin/ProviGen) and [AutoCursor](https://github.com/yongjhih/AutoCursor) could be relevant
    - use of an [ORM](https://android-arsenal.com/tag/69)
        - [requery](https://github.com/requery/requery), [DBFlow](https://github.com/Raizlabs/DBFlow) or [OrmLite](https://github.com/j256/ormlite-android) for example
