ShareWebShortcut (Java Application)
==============================

Summary
-------
Java application which launches web shortcuts files.

This application may not work with all operating systems.
Due to differences in operating systems, it is difficult for
Java to opena browser in a 100% reliable way.
I attempted to use the BrowserLauncher2 library, but had difficulties.
Due to time constraints, I just used a custom-built launching algorithm
(with some help from this blog entry:
http://www.mkyong.com/java/open-browser-in-java-windows-or-linux/ )

Usage
-----
java -jar LaunchWebShortcut.jar "filename"

filename indicates the shortcut file to open.  The shortcut
type will be determined by the file extension.

Websites
--------
Main Website: http://beckus.github.io/WebShortcutUtil/<br/>
Source Code:  https://github.com/abcodeworks/LaunchWebShortcut-Java/<br/>

Building
--------
- To compile:<br/>
  mvn compile

- To package:<br/>
  mvn package<br/>
  The jar file is in the target/ folder
  
Libraries and Licenses
----------------------
This project is released under the Apache License 2.0.

The following libraries are used:
-   com.abcodworks.webshortcututil - Apache License 2.0

webshortcutuil includes the following libraries:
-   com.dd.plist - http://code.google.com/p/plist/ - MIT License
-   com.beetstra.jutf7 http://jutf7.sourceforge.net/ - MIT License

All licenses can be found in the root folder.
