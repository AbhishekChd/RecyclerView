# RecyclerView

App demonstartes working of Recycler View and differnet layout managers and contains 3 placeholder images of different sizes.
- 800 x 800
- 800 x 900
- 900 x 800

This would demonstrate how elements of different size will behave in same environment.

## Index <img src="https://image.flaticon.com/icons/svg/174/174836.svg" width="25px">
1. [What is Recycler View?](#what-is-recycler-view)
2. [Working](#working)
3. [Main Files](#main-files)
4. [Layouts](#layouts)

## What is Recycler View?
 **Recycler View as said by name Recycles the views. Fundamental of Recycler View is that it keeps as many views in memory as needed to display on screen + least amount needed to display nice animation.**
 
 **What do I mean by that?**
 Suppose an app shows 6 views on your screen and you scroll down and you see another view instantly, and for that to happen some extra views were created to display that smooth scroll. Hence total views created? 6 + some extra views which is still better than loading 100s of views in memory at once.

### Let's get into Recycler View
![Recycler View](https://developer.android.com/training/material/images/RecyclerView.png)

As we can see, **RecyclerView** contains a **Layout Manager** which determines how the data would be displayed. **Layout** can be Linear, Grid or Staggered.
The RecyclerView then calls for an **Adapter** which manages the logic of your Views and it calls for **Data** as well hence all the functionality given to Views is provided in Adapters.
 
 

## Working
In [MainActivity.java](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/java/com/example/abhishek/workingwithimages/MainActivity.java) I have defined 2 variables, **layout** and **spanCount**.

**layout** is defined for type of Layout you want to see.
* 0 for LinearLayout - VERTICAL
* 1 for LinearLayout - HORIZONTAL
* 2 for GridLayout
* 3 for StaggeredLayout

**spanCount** is defined for GridLayout and Staggered GridLayout and is to tell how many columns you want. **Default value is 2.**

In [ImageAdapter.java](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/java/com/example/abhishek/workingwithimages/ImageAdapter.java) there are 2 important variables, **TOTAL_IMAGES** and **IMAGE_COUNT**

**TOTAL_IMAGES** is to manage how many images do you want to display. **Default is 100**

**IMAGE_COUNT** is for to display different images.
* 1 for (800 x 800)
* 2 for (800 x 800, 900 x 800) where width is to be kept same
* 3 for (800 x 800, 900 x 800, 800 x 900) both width and height varies

## Main Files
- [MainActivity.java](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/java/com/example/abhishek/workingwithimages/MainActivity.java)
- [ImageAdapter.java](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/java/com/example/abhishek/workingwithimages/ImageAdapter.java)
- [image_list_item.xml](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/res/layout/image_list_item.xml)
- [activity_main.xml](https://github.com/AbhishekChd/RecyclerView/blob/master/app/src/main/res/layout/activity_main.xml)

## Layouts

### 1. Linear Layout- Vertical Orientation
<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/LinearLayoutV.png" alt="Linear Layout in vertical orientatiion" width="40%">

### 2. Linear Layout- Horizontal Orientation
<p>
<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/LinearLayoutH.png" alt="Linear Layout in vertical orientatiion" width="40%">

<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/LinearLayoutH2.png" alt="Linear Layout in vertical orientatiion" width="40%">
</p>

### 3. Grid Layout- Different Images
<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/GridLayout Diff.png" alt="Linear Layout in vertical orientatiion" width="40%">

### 4. Grid Layout- Same Images
<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/GridLayout same.png" alt="Linear Layout in vertical orientatiion" width="40%">

### 5. Staggered Grid Layout
<img src="https://raw.githubusercontent.com/AbhishekChd/RecyclerView/master/app/src/main/res/drawable/Staggered.png" alt="Linear Layout in vertical orientatiion" width="40%">

