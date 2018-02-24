# RecyclerView

App demonstartes working of Recycler View and differnet layout managers and contains 3 placeholder images of different sizes. This would demonstrate how elements of different size will behave in same environment and it's performance.

## Run the APP
 **Beginner**
 1. Download the repo as .zip
 2. Extract it and place it at desired location
 3. Open Android Studio and click on import
 4. Navigate to extracted folder and click on it
 5. Click ok
 6. Then click the Run App button
 
 **Preffered**
 1. Fork the repo
 2. Open Android Studio, Goto VCS > Clone from GitHub
 3. Enter .git URL of your forked repo
 4. Press ok and let it finish
 5. Run the app

## Index <img src="https://image.flaticon.com/icons/svg/174/174836.svg" width="25px">
1. [What is Recycler View?](#what-is-recycler-view)
2. [Working of App](#working)
3. [Main Files](#main-files)
4. [Screenshots](#layouts)

## What is Recycler View?
 **Recycler View as said by name Recycles the views. Fundamental of Recycler View is that it keeps as many views in memory as needed to display on screen + least amount needed to display nice animation.**
 
 **What do I mean by that?**
 Suppose an app shows 6 views on your screen and you scroll down and you see another view instantly, and for that to happen some extra views were created to display that smooth scroll. Hence total views created? 6 + some extra views which is still better than loading 100s of views in memory at once.

### 1. Let's get into Recycler View
<p align="center"><img src="https://developer.android.com/training/material/images/RecyclerView.png" width="65%"></p>

As we can see, **RecyclerView** contains a **Layout Manager** which determines how the data would be displayed. **Layout** can be Linear, Grid or Staggered.
The RecyclerView then calls for an **Adapter** which manages the logic of your Views and it calls for **Data** as well hence all the functionality given to Views is provided in Adapters.

Now, I'll explain each aspect of code individually so that you can always create from scratch using it.

### 2. Dependency
``` java
com.android.support:recyclerview-v7:27.0.2
```

### 3. Layout
```xml
<android.support.v7.widget.RecyclerView
  android:layout_width="match_parent"
  android:layout_height="match_parent"
...
 />                                     
```
List item to be displayed in RecyclerView should be created as different layout(*e.g.* list_item.xml) file

### 4. Code

Here, in main activity I used **findViewById** to get recycler view.
We have RecyclerView, now we need an Adapter. (RecyclerView Adapter forces to create a ViewHolder so than memory can be saved because for all list items there is single viewHolder)

We create a new file naming it **SomeAdapter**
Then we extend **RecyclerView.Adapter** to use it's functionality
``` java
// I'll explain the ViewHolder later below for now see it as single list item's View
class SomeAdapter extends RecyclerView.Adapter<SomeAdapter.SomeAdapterViewHolder>{
...
}
```
Then we Override certain methods, I'll explain them individually:
1. <code>onCreateViewHolder(ViewHolder parent, int viewType)</code> : This method manages what happens when View is created. RecyclerView on creates some view, just enough fr smooth scrolling (I explained that above).
   1. **parent** is the Parent View where all the list items will be contained in.
   2. **viewType** is used when we have more than one viewType
   Here we use Inflater to inflate a view (list_item.xml as told above) for single list item and return it.
   ``` java
   // This gets the context of Parent View
   Context context = parent.getContext();
   
   // This is the id of layout file (Defined for single list item)
   int listItemId = R.layout.image_list_item;
   
   // Attach to parent view immediately
   boolean attachToRootImmediately = false;
   
   // This inflates the list_item view and attaches to parent, then returned as new View
   View view = LayoutInflater.from(context).inflate(listItemId, parent, false);
   
   // This makes a new ViewHolder and passes this newly created view as parameter
   return new SomeViewHolder(view);
   ```
   
2. <code>onBindViewolder(ViewHolder holder, int position)</code> : When we scroll same view created in the beginning are kept throughout run of our app, hence just the data is changed, which happens here. Binding means the view is on screen and needs data (Remember as I told above, an Adapter needs data). We need to instruct it how to get and display data.
    1. **holder**: It is single item we want to show (list_item.xml)
    2. **position**: It is the position of item in list, and hence we can show data as per position in list
    ``` java
    // Holder is View of individual list item at (position)
    holder.someTextView.setText("This will appear on each list");
    ```
  
3. <code>int getItemCount()</code> : For fast access we provide the length of list directly if possible. This makes manupulation of list easy and lite for RecyclerView.
    ``` java
    int IMAGE_COUNT = 100;
    ...
    @Override
    protected int getItemCount(){
      return IMAGE_COUNT;
    }
    ```
Now, the **Adapter** has been set up and now we need to define a **ViewHolder**. First what is a ViewHolder?
As I told many times by now, it has it's own layout file which is for individual list item in our list. For this app I have **ImageView in a LinearLayout for ViewHolder**.

How to define it?
We can make a seperate Java file as **SomeAdapterViewHolder** and inherit **RecyclerView.ViewHolder** to get ViewHolder's properties and methods.
``` java 
class SomeAdapterViewHolder extends RecyclerView.ViewHolder{
...
}
```

Then we make default constructor which can be done as, <kbd>ALT + INSERT</kbd> and click on **Constructor** which will write the code for us.
What this does? When a ViewHolder is made in <code>onCreateViewHolder</code> in **Adapter** class then a view is passed. This tells the ViewHolder what View to display
``` java
 public SomeViewHolder(View itemView) {
  super(itemView);

 }
```

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

**IMAGE_COUNT** is to display different images.
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

