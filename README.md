# Loading ![JitPack](https://img.shields.io/badge/release-1.0.0-brightgreen.svg)

##### A Dialog of loading which used for waiting network request or other time-consuming operation。
# Preview

<img src="https://github.com/lizihanglove/Loading/blob/master/art/loading.gif" width="200" hegiht="500" align=center />

# Usage  ![JitPack](https://img.shields.io/badge/jitpack-1.0.0-green.svg)

###### Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

###### Step 2. Add the dependency
```
	dependencies {
		implementation 'com.github.lizihanglove:Loading:v1.0.0'
	}
```

##### Step 3. Build a dialog
###### a.Java
```
  Loading loading = new Loading.Builder(MainActivity.this)
                  .setCancelable(false)
                  .build();
  loading.show();
  loading.dismiss();
```
###### b.Kotlin
```
  var loading:Loading = Loading.Builder(activity).setCancelable(true).build()
  loading.show()
  loading.dismiss()
```

# license [![GitHub license](https://img.shields.io/github/license/lizihanglove/Loading.svg)](https://github.com/lizihanglove/Loading/blob/master/LICENSE)





