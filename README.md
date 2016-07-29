# Utils Android Library

Description
-
This is my personal collection of utility methods and classes frequently used during android development to reduce boilerplate code and shorten development time. Stuff will be added regularly whenever new stuff comes up that cries out for being added to a utility library.

Categories
-
* Assert
* DateTime
* Graph
* IO
* Math
* Net
* Security
* Text
* UI
* General


Versions
-

Current version is 1.0.13

License
-
It is free software, and may be redistributed under the terms specified in the LICENSE file.

To include the library
-

To include the library into your project, build it as an library AAR file, copy it into your app/libs folder and add the following lines to your app build.gradle file:

```shell
compile fileTree(dir: 'libs', include: ['*.jar'])
compile(name: 'utils', ext: 'aar')
```
