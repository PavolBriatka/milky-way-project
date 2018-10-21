# milky-way-project
<p>In this project, I decided to try and implement MVP pattern. I have created specific packages for each of the elements (model, view, presenter). Each package contains files that, in my opinion, belong there and correspond with an element of the <i><b>MVP pattern</b></i>.</p>
<p>The network request is handled by Retrofit (in combination with Gson converter) which passes the response through a listener to Presenter and from there to Activity (View) where the data is passed to an adapter and UI is populated with the items.</p>
<p>The list of items is shown in a recycler view which uses a layout manager to handle the UI when the screen is rotated (the portrait mode shows a vertical linear list of items and the landscape mode show the items in a grid view in two columns).</p>
<p>Passing the correct data and opening the detail activity is handled through a simple recycler view on-click listener which takes the clicked object as a parameter and then it’s attached to an intent as an extra in form of a parcelable object.</p>
<p>The detail activity is structured in a coordinator layout that contains app bar layout and a nested scroll view. The image is a part of the collapsing toolbar layout that supports scrolling and scrim effect.</p>
<p>The app uses 3rd party libraries (Retrofit being one of them) such as ButterKnife for easy dependency injection that detects problems (if there are any) during the compile time – which improves the time spent on coding. Another library that I used is Picasso for smooth picture loading and caching, and also it uses .error() method to handle broken images.</p>
<p>Areas to improve:
<ol>
<li>I have included a couple of very simple tests – two UI tests, and one Unit test. Even though I have general knowledge about the testing I would like to get deeper into the topic to be able to write more quality tests to deliver more quality code.</li>
<li>If I was supposed to improve the app I would implement fragments to support master-detail flow for tablets and generely to support repsonsive and adaptive design.</li>
</ol></p>
