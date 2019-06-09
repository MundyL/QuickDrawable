添加依赖
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
	        implementation 'com.github.MundyL:QuickDrawable:0.1.3'
	}
```
然后下面我们来看看如果用代码实现平时所需要的各种效果。
```
new QuickDrawable()
                .color(Color.RED)//设置背景色
               // .color(Color.parseColor("#f34563")) 也可以这样设置颜色
                //.color(ContextCompat.getColor(this,R.color.colorPrimary)) 也可以这样设置颜色
                .corner(10)//设置圆角,所有此类值的单位都是dp
                .into(btn1);
```
上面的方法可以实现控件的圆角。背景颜色，边框。
属性说明：
color：设置背景颜色，可以用Color.RED系统颜色，也可以使用Color.parseColor自定义色码，也可以使用ContextCompat.getColor(this,R.color.colorPrimary) 引用资源文件设置好的颜色
corner：设置控件的圆角，提供了一个参数的方法和四个参数的方法，设置一个参数则四个角相等，也可以分别设置四个角的圆角。
下面我们再来看看如何设置边框和边框颜色
```
new QuickDrawable()
                 .corner(10,10,0,0)//单独设置4个圆角
                //.border() 不传参数则默认1dp
                .border(10)
                .borderColor(Color.parseColor("#f34563"))//设置边框颜色.
                .into(btn2);
```
border:当不传入参数时则默认1dp的边框，传入参数则可以自定义边框大小
borderColor:设置边框颜色的方法
当我们需要做按钮的按下效果的时候，可以用下面的方法来实现
```
new QuickDrawable().corner()
                .color(Color.RED)
                .addToPressed(true)
                .color(Color.CYAN)
                .addToPressed(false)
                .textColor(Color.BLUE,Color.YELLOW)
                .into(btn3);
```
首先是按照我们图一和图二的方法。设置按钮的样式，然后用addToPressed使前面设置的样式成为按钮的pressed的样式。这样便可以实现按钮按下的效果。
当然，不止可以这样用。还有其他的方式。下面就来看一下我们的方法说明。
addToPressed(boolean b):这个方法是将此方法调用前面的样式设置成按钮效果。true和false分别表示Pressed的true和false.和我们平常写drawable文件中的意思一样。
addPressed(int backgroundColor,boolean b):如果不需要各种圆角边框，只需要直接设置颜色，可以用这个方法。
addPressedDrawable(Drawable drawable,boolean b)：可以使用drawable设置效果。当我们需要使用图片或者其他drawable资源作为点击效果的时候，可以使用这个方法.
除了上面这些还有
addChecked
addToChecked
addCheckedDrawable
addEnable
addToEnable
addEnableDrawable
这些可以设置各种状态下的背景样式。
如果需要实现文字颜色变化。这里提供了这个方法
```
textColor(int uncheck,int check)
```
可以设置正常状态下文字颜色和选中或者按下时文字的颜色
根据这几个方法。我们就可以这样做
```
QuickDrawable quickDrawable=new QuickDrawable();
//标签切换效果
        quickDrawable
                .corner(20,0,20,0)
                .color(Color.RED)
                .addToChecked(true)
                .borderColor(Color.RED)
                .corner(20,0,20,0)
                .addToChecked(false)
                 .textColor(Color.RED,Color.WHITE)
                .into(rbLeft);
        quickDrawable
                .corner(0,20,0,20)
                .color(Color.RED)
                .addToChecked(true)
                .borderColor(Color.RED)
                .corner(0,20,0,20)
                .addToChecked(false)
                .textColor(Color.RED,Color.WHITE)
                .into(rbRight);
```
这样我们就实现了下图这种我们经常用到的RadioButton切换效果








