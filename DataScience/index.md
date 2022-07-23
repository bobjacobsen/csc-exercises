# Data Science CSC Exercises

Please read this all the way through first to get a idea of the overall plan of the exercises.  Note that there's some general information at the end.

## Getting Started

We use the CERN SWAN service for these exercises.  You should already have an account.

To access SWAN
(URL)
(Login)
(...)
(git clone --depth 2 https://github.com/bobjacobsen/csc-exercises.git)
Exercises are in Data Science directory

## About the Exercises

There are three categories...

To do each exercise, navigate SWAN to the folder for the exercise, then launch the .ipynb file found there.  For some exercises, there are also data files that you can browse by opening them in the notebook.


### Introductory

These are meant to be an good starting point to make sure that your technical setup is working and to give you familiarity with Jupyter notebooks and analysis packages. Be sure to do the first one ("Old Faithful") to make sure everything is working, then do one or two of the following ones that you find interesting. Each has some additional calculations and questions at the end, beyond what we did in lecture, for your exploration and enjoyment.

A lot of analysis code is written by copy-and-paste from prior notebooks (and sometimes from [StackOverflow](https://stackoverflow.com/questions/66675146/calculate-the-difference-between-pandas-rows-in-pairs)...).  Even if you skip doing some of these, you might want to open them to copy how to make a particular calculation or plot.

_Old Faithful_

This is the Jupyter Notebook that started the lectures. To start, just work through each cell:  Look at it, decide what it will do, then run it.  Once you get toward the bottom, you're prompted to use the same ideas to answer a few more questions from the data.

_Toast_

Introduction to simulating a distribution.

_Juries_

Simulating multi-dimensional distribution.

_Drinks_

Intro to joining separate data-sets together.

_Bikes_

More joining and multi-dimensional statistics, followed by mapping of geographic data.

(The second half of this might have been better in the Intermediate category)

_Textual Analysis_

Searching and counting in a text data set.



### Intermediate

These are meant to give you more experience with analysis. Please feel free to spend as much as or as little time as you'd like on these.  If you think of other questions you'd like to answer from the data, go ahead and do that! If you get stuck, look in the `solutions` directory.

_Movies_



_Census 1 and Census 2_



### Advanced/Optional

If you have time, there are some optional projects where you can try out these techniques on more interesting problems with larger data sets.

In the `Projects` directory you will find several project subdirectories. In order of increasing depth and size, these are:

0) Use some SCADA data to check the health of a cooling system

1) An examination of global demographics

2) An examination of heart health and disease

3) Building a movie classifier

Each of these is a mix of pre-provided computations, explanations, and cells that you have to fill out.  The first one (SCADA) is somewhat self-directed and open-ended; the last three are more step-by-step, but much larger.

Pick one that sounds interesting and get as far as you can on it.  Don't worry about completing them, they're significant projects that are meant to more than fill the exercise period.




## General Information

If you want to run these on your own machine, first install Jupyter Notebooks.  There are several ways to do this, but perhaps the most straight-forward is to [use PIP](https://jupyter.org/install).

Then checkout the exercise material to your machine. During the CERN School, please use the head of the `master` branch.  After the School is over, you can checkout the `CSC2022` tag to get exactly these exercises.


### Documentation

 - [`numpy` package](https://numpy.org/doc/)

 - [`pandas` package](https://pandas.pydata.org/docs/)
   - [API reference](https://pandas.pydata.org/docs/reference/index.html#api)

 - [`datascience` package](http://data8.org/datascience/index.html)
    - [Manual](https://readthedocs.org/projects/datascience/downloads/pdf/master/)

 - [`matplotlib` package](https://matplotlib.org/stable/index.html)

 ### Data

 One good source of data sets is [Google Dataset Search](https://datasetsearch.research.google.com).  For more, see [this blog entry](https://www.blog.google/products/search/making-it-easier-discover-datasets/).

