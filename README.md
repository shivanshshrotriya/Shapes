# Shapes
  Add Different Shapes in Android Projects

# Steps To ADD:

## 1. ADD Dependency
    dependencies {
	        implementation 'com.github.shivanshshrotriya:Shapes:v1.1'
	}
  
     allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
## 2. There Are Four Shapes
    - Circle
    - Oval
    - Rectangle
    - Round Rectangle
    
### Add Below to "activity.xml"

### Add this line to Parent Layout/View Group of Activity
     xmlns:custom="http://schemas.android.com/apk/res-auto"

## For Oval
      
        <com.timepasstechnologies.shape.Oval
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:shapeColor="#000080"
        custom:shapeLabel="Oval"
        custom:labelColor="#FFD700"/>

## For Circle
    
    <com.timepasstechnologies.shape.Circle
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:shapeColor="#000080"
        custom:shapeLabel="Circle"
        custom:labelColor="#FFD700"/>
   
## For Rectangle

    <com.timepasstechnologies.shape.Rectangle
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:shapeColor="#000080"
        custom:shapeLabel="Rectangle"
        custom:labelColor="#FFD700"/>

## For Round Rectangle

    <com.timepasstechnologies.shape.Round_Rectangle
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:shapeColor="#ff0099"
        custom:shapeLabel="Round Rectangle"
        custom:labelColor="#FFD700"/>

## For Example:
[Go Here](https://github.com/shivanshshrotriya/Shapes/blob/master/app/src/main/res/layout/activity_main.xml).




        
