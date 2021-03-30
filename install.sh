echo ""
echo ""
echo " ██▓ ███▄ ▄███▓ ▄▄▄        ▄████ ▓█████     ▒█████    █████▒   ▄▄▄█████▓ ██░ ██ ▓█████    ▓█████▄  ▄▄▄     ▓██   ██▓"
echo "▓██▒▓██▒▀█▀ ██▒▒████▄     ██▒ ▀█▒▓█   ▀    ▒██▒  ██▒▓██   ▒    ▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▒██▀ ██▌▒████▄    ▒██  ██▒"
echo "▒██▒▓██    ▓██░▒██  ▀█▄  ▒██░▄▄▄░▒███      ▒██░  ██▒▒████ ░    ▒ ▓██░ ▒░▒██▀▀██░▒███      ░██   █▌▒██  ▀█▄   ▒██ ██░"
echo "░██░▒██    ▒██ ░██▄▄▄▄██ ░▓█  ██▓▒▓█  ▄    ▒██   ██░░▓█▒  ░    ░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ░▓█▄   ▌░██▄▄▄▄██  ░ ▐██▓░"
echo "░██░▒██▒   ░██▒ ▓█   ▓██▒░▒▓███▀▒░▒████▒   ░ ████▓▒░░▒█░         ▒██▒ ░ ░▓█▒░██▓░▒████▒   ░▒████▓  ▓█   ▓██▒ ░ ██▒▓░"
echo "░▓  ░ ▒░   ░  ░ ▒▒   ▓▒█░ ░▒   ▒ ░░ ▒░ ░   ░ ▒░▒░▒░  ▒ ░         ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░    ▒▒▓  ▒  ▒▒   ▓▒█░  ██▒▒▒ "
echo " ▒ ░░  ░      ░  ▒   ▒▒ ░  ░   ░  ░ ░  ░     ░ ▒ ▒░  ░             ░     ▒ ░▒░ ░ ░ ░  ░    ░ ▒  ▒   ▒   ▒▒ ░▓██ ░▒░ "
echo " ▒ ░░      ░     ░   ▒   ░ ░   ░    ░      ░ ░ ░ ▒   ░ ░         ░       ░  ░░ ░   ░       ░ ░  ░   ░   ▒   ▒ ▒ ░░  "
echo " ░         ░         ░  ░      ░    ░  ░       ░ ░                       ░  ░  ░   ░  ░      ░          ░  ░░ ░     "
echo "                                                                                           ░                ░ ░     "
echo ""
echo ""

echo "Image-Of-The-Day"
echo "      - Version v0.1.4"

echo ""
echo "GitHub: <https://github.com/tucnakomet1/Image-Of-The-Day>"
echo "Author: Karel Velička (Tucnakomet)"
echo ""

path=$(pwd)
read -p "Do you want to install Image-Of-The-Day? [Y/n]" inst

if [ $inst = "Y" ] || [ $inst = "y" ]; then
    echo "Image-Of-The-Day will be installed to your system!"
    echo ""
    echo ""
    echo "Checking java dependencies..."
    echo ""
    isjava=$(which java)
    if [ $isjava != "" ]; then
        echo ""
        echo "Java is installed..."
        echo ""
    else
        echo ""
        echo "Java is not installed!"
        echo "Java installation..."
        debDis=$(which apt-get)
        echo ""
        if [ $debDis != "" ]; then
            read -p "Do you want to install Java? [y/N]" sooo
            if [ $sooo = "N" ] || [ $sooo = "n" ]; then
                echo "You can not run Image-Of-The-Day without java!"
                exit
            fi
            wget --no-check-certificate -c --header "Cookie: oraclelicense=accept-securebackup-cookie" https://download.oracle.com/otn-pub/java/jdk/15.0.2+7/0d1cfde4252546c6931946de8db48ee2/jdk-15.0.2_linux-x64_bin.tar.gz
            sudo mkdir /usr/lib/jvm
            cd /usr/lib/jvm
            sudo tar -xvzf $path/jdk-15.0.2_linux-x64_bin.tar.gz
            sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-15.0.2/bin/java" 0
            sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-15.0.2/bin/javac" 0
            sudo update-alternatives --set java /usr/lib/jvm/jdk-15.0.2/bin/java
            sudo update-alternatives --set javac /usr/lib/jvm/jdk-15.0.2/bin/javac
            update-alternatives --list java
            update-alternatives --list javac
            java -version
            echo ""
            echo "Java is successfully installed."
            echo ""
        else
            echo ""
            echo "Your distribution is not supported!"
            echo "Install java and then repeat installation."
            echo "Thank you!"
            exit
        fi
    fi

    echo ""
    read -p "Do you want to create a Desktop Shortcut? [Y/n]" DeskShortcut
    read -p "Do you want to create a Application Menu Shortcut? [Y/n]" MenuShortcut
    if [ $DeskShortcut = "Y" ] || [ $DeskShortcut = "y" ] || [ $MenuShortcut = "Y" ] || [ $MenuShortcut = "y" ]; then
        touch $path/img_of_the_day.desktop
        echo "[Desktop Entry]" >> $path/img_of_the_day.desktop
        echo "Version=0.1.4" >> $path/img_of_the_day.desktop
        echo "Type=Application" >> $path/img_of_the_day.desktop
        echo "GenericName=Image-Of-The-Day" >> $path/img_of_the_day.desktop
        echo "Name=Image-Of-The-Day" >> $path/img_of_the_day.desktop
        echo "Categories=Application;System;Utility;Settings" >> $path/img_of_the_day.desktop
        echo "Keywords=image;image-of-the-day;day;img;iotd;" >> $path/img_of_the_day.desktop
        echo "Exec=java -jar ImageOfTheDay.jar" >> $path/img_of_the_day.desktop
        echo "Path=$path" >> $path/img_of_the_day.desktop
        echo "Icon=$path/src/images/Logo/logo.png" >> $path/img_of_the_day.desktop
        echo "Terminal=false" >> $path/img_of_the_day.desktop
        sudo chmod +x $path/img_of_the_day.desktop
        
        if [ $DeskShortcut = "Y" ] || [ $DeskShortcut = "y" ]; then
            echo ""
            read -p "Is '$(xdg-user-dir DESKTOP)' your Desktop directory? [Y/n]" desktop
            if [ $desktop = "Y" ] || [ $desktop = "y" ]; then
                desk=$(xdg-user-dir DESKTOP)
            else
                read -p "Enter your Desktop directory?" desk
            fi

            sudo cp $path/img_of_the_day.desktop $desk/img_of_the_day.desktop
            echo ""
            echo -e "Done! Desktop shortcut created!"
            echo ""
        fi

        if [ $MenuShortcut = "Y" ] || [ $MenuShortcut = "y" ]; then
            sudo cp $path/img_of_the_day.desktop /usr/share/applications/
            echo ""
            echo -e "Done! Application Menu shortcut created!"
            echo ""
        fi
    fi

    mkdir ~/.images
    mkdir ~/.ImageOfTheDay/

else
    echo "So sad!"
fi
