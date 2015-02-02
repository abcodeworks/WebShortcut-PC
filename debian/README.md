Debian Installer
=================
This folder contains everything necessary to build a Debian install package.

Refs
----
- http://ubuntuforums.org/showthread.php?t=910717
- http://www.freedesktop.org/wiki/Specifications/AddingMIMETutor/

Building the Installer
----------------------
- Commands to build the installer (run in this sequence).  Note that the lintian command gives some
  warnings, but I am ignoring them:
  Build WebShortcutLaunch.jar and put it into a folder "package/usr/share/java" folder.
  cd debian
  rm -R package/DEBIAN/control~
  sudo find package/usr -type d -exec chmod 755 {} \;
  sudo find package/usr -type f -exec chmod 644 {} \;
  sudo chown -R root:root package/usr
  sudo dpkg-deb --build package
  lintian package.deb
  mv package.deb webshortcuttools_0.1.1-1.deb
  
- To restore permissions:
  sudo find package/usr -exec chmod 755 {} \;
  sudo chown -R andre:andre package/usr


Notes
-----
- On Ubuntu (12.04 and 14.04), the following mime type exists, although there does not appear to be any
  application associated with it: application/x-mswinurl .  The xml file is:
  /usr/share/mime/application/x-mswinurl.xml
  I included this mime type in the installer in case it is not in some Linux distributions.  This does
  not seem to cause any harm, although it does add duplicate entries in the above xml.  Fortunately, these
  extra entries appear to be removed if the package is uninstalled.


Testing the Package
-------------------
- Installing the package (firs tinstall it, then fix dependencies):
  sudo dpkg -i package.deb
  sudo apt-get install -f
- Remove package:
  sudo dpkg -r webshortcuttools

Useful Commands for Experimenting
---------------------------------
- Installing a desktop file:
  sudo desktop-file-install --rebuild-mime-info-cache webshortcutlaunch.desktop
- Check MIME type of a file (the "file" command does not seem to give the right info
  on Ubuntu):
  xdg-mime query filetype FILE
- Updating the various caches:
  sudo update-mime-database /usr/share/mime
  sudo update-desktop-database
  sudo gtk-update-icon-cache /usr/share/icons/gnome/ -f


