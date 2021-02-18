touch $(xdg-user-dir DESKTOP)/img_of_the_day.desktop

echo "[Desktop Entry]" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Version=0.0.1" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "GenericName=Image-Of-The-Day" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Name=Image-Of-The-Day" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Categories=Application;System;Utility;Settings" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Exec=" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Icon=/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
echo "Terminal=false" >> $(xdg-user-dir DESKTOP)/img_of_the_day.desktop

sudo chmod +x $(xdg-user-dir DESKTOP)/img_of_the_day.desktop

sudo cp $(xdg-user-dir DESKTOP)/img_of_the_day.desktop /usr/share/applications/