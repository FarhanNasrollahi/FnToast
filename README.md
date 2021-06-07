<h1>FnToast</h1>

Add this in your app's build.gradle file(Using Android Studio and Gradle):

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

    dependencies {
	        implementation 'com.github.farhanff:FnToast:0.1.0'
	}

For use Code :

```
FnToast fnToast = new FnToast(MainActivity.this);
            fnToast.setBackgroundColor(Color.BLUE);
            fnToast.setTextColor(Color.BLACK);
            fnToast.setText("salam");
            fnToast.setRadius(10);
            fnToast.setMargin_L_R(40);
            fnToast.setIconVisibility(true);
            fnToast.setForceDark(false);
            fnToast.setDuration(FnToast.LENGTH.SHORT);
            fnToast.show();

```
