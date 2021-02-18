<h1 align="center" id="head">Image Of The Day</h1>

<a href="https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/images/Logo/logo.png"><img src="https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/images/Logo/logo_75x75.png" alt="info"  style="max-width:10%;" align="left" hspace="10"></a>Image-Of-The-Day is a JavaFX project that allows you to see, download or set image as a wallpaper from [NASA](https://www.nasa.gov/), [Bing](https://bing.com/), [National Geographic](https://www.nationalgeographic.co.uk/), [etc.](#resources) in a friendly graphical interface. Software can be installed on any Windows, MacOS or Linux device. This project is mainly used for self-improvement in Java and to understand the JavaFX library. Any idea for upgrade is welcome.
<h2></h2>

<h2>Table of contents</h2>


* <a href="#install">INSTALLATION</a><br/>
  * <a href = "#windows">Windows</a><br/>
  * <a href = "#linux">Linux</a><br/>
  	* <a href = "debian">Debian based</a><br/>
  	* <a href = "arch">Arch based</a><br/>
  	* <a href = "fedora">Fedora based</a><br/>
  * <a href = "#darwin">MacOS</a><br/>
  * <a href = "tar">Tarball/ Source</a><br/>
* <a href = "#resources">RESOURCES</a><br/>
* <a href = "#libraries">LIBRARIES</a><br/>
* <a href = "#screen">SCREENSHOTS</a><br/>
* <a href = "https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/USAGE.md">USAGE</a><br/>
* <a href = "https://github.com/tucnakomet1/Image-Of-The-Day/releases">RELEASES</a><br/>
* <a href = "#license">LICENSE</a><br/>
* <a href = "#contact">CONTACT</a><br/>

<br/><br/><br/>

<h2 id="install">INSTALLATION</h2>

 * <a href = "#windows">Windows</a><br/>
 * <a href = "#linux">Linux</a><br/>
     * <a href = "debian">Debian based</a><br/>
     * <a href = "arch">Arch based</a><br/>
     * <a href = "fedora">Fedora based</a><br/>
 * <a href = "#darwin">MacOS</a><br/>
 * <a href = "tar">Tarball/ Source</a><br/>

<h3 id="windows">Windows</h3>

Download newest [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases) and choose your preferred installation format ( **.exe** *(preinstalled)* / **.msi**)

<br/>

<h3 id="linux">Linux</h3>

<h4 id="debian">Debian based</h4>

You can download *.deb* package using latest [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases) site or using this installation script:

```bash
cd $(xdg-user-dir DOWNLOAD) # navigate you to your 'Downloads' folder
version=$(curl https://raw.githubusercontent.com/tucnakomet1/Image-Of-The-Day/master/controllers/version.txt?token=ANH373DML6YIYETAPBYP6Y3AFUC3E | tr -s "version " "v") # get latest version
echo $version
wget https://github.com/tucnakomet1/Image-Of-The-Day/releases/download/$version/image-of-the-day-$version.deb # download the package
sudo dpkg -i image-of-the-day-$version.deb # unpack and install the package
```

<h4 id="arch">Arch based</h4>

You can download *.* package using [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases) site or using this installation script:

```bash

```

<h4 id="fedora">Fedora based</h4>

You can download *.* package using [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases) site or using this installation script:

```bash

```


<br/>

<h3 id="darwin">MacOS</h3>

Download newest [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases) and choose your installation format ( *.dmg*).

<br/>

<h3 id="tar">Tarball/ Source</h3>

Download the latest tar [release](https://github.com/tucnakomet1/Image-Of-The-Day/releases)
Use any file manager or run command to extract:
`tar -xvzf Image-Of-The-Day*.tar.gz`
Go to the folder and run installation scripts
```bash
cd Image-Of-The-Day
sudo chmod +x install.sh
./install.sh
```


Download and install from source code:

```bash 
git clone https://github.com/tucnakomet1/Image-Of-The-Day.git
cd Image-Of-The-Day
sudo chmod +x install.sh
./install.sh
```
<br/>

<br/><br/><br/>

<h2 id="resources">RESOURCES</h2>

* [Bing](https://bing.com/)
* [NASA](https://www.nasa.gov/)
* [Unsplash](https://unsplash.com/)
* [National Geographic](https://www.nationalgeographic.co.uk/)
* [Wikimedia Commons](https://commons.wikimedia.org/wiki/Main_Page)
* [Big Geek Dad](https://biggeekdad.com/)
* [Earth Observatory (NASA) ](https://earthobservatory.nasa.gov/)
* [Astronomy Picture of the Day (NASA)](https://apod.nasa.gov/)
* [EPOD-USRA](https://epod.usra.edu/)
* [NESDIS-NOAA](https://www.nesdis.noaa.gov/)

<br/><br/><br/>

<h2 id="libraries">LIBRARIES</h2>

Created with [Java openjdk-15.0.2](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) and [JavaFX javafx-sdk-15.0.1](https://gluonhq.com/products/javafx/)

* Json-simple (1.1.1) - [download](https://gitlab.cs.washington.edu/cse332-16au/p1/blob/master/json-simple-1.1.1.jar)
* Jsoup (1.13.1) - [download](https://jsoup.org/download)
* webp-imageio-core (0.1.3) - [download](https://github.com/nintha/webp-imageio-core)

<br/><br/><br/>

<h2 id="screen">SCREENSHOTS</h2>

![splashscreen](https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/screenshots/SplashScreen.png)

![mainpage](https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/screenshots/mainpagegif.gif)

![settings](https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/screenshots/settings.png)<br/><br/><br/>

<h2 id="license"> LICENSE </h2>

[Open Source MIT License](https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/LICENSE)

```txt
MIT License

Copyright (c) 2021 Tucna

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

<br/><br/><br/><br/>

<h2 id="contact">CONTACT</h2>

You can contact me via my gmail address <a href="mailto:tucnakomet@gmail.com">tucnakomet@gmail.com</a>.<br/>
 <br/>

If you like my project you can look at my [profile](https://github.com/tucnakomet1) or straight visit my next project [who-is-on-my-wifi](https://github.com/tucnakomet1/Python-Who-Is-On-My-WiFi).

</br></br>

<a href = "#head"><span title="Go UP!"><img alt="up" src="https://ps.w.org/wpfront-scroll-top/assets/icon.svg?rev=1534312" width="40" height="40" style="border:0px solid;" /></a></span><a href = "https://github.com/tucnakomet1"><span title="GitHub"><img alt="github" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/1200px-Octicons-mark-github.svg.png" width="40" height="40" style="border:0px solid;" /></a></span>

