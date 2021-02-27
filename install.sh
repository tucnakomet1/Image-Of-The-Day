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
echo "      - Version v0.1.3-release"

echo ""
echo "GitHub: <https://github.com/tucnakomet1/Image-Of-The-Day>"
echo "Author: Karel Velička (Tucnakomet)"
echo ""

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
        fedDis=$(which yum)
        if [ $debDis != "" ] || [ $fedDis != "" ] ; then
            echo "You are Debain based!"
            wget --no-check-certificate -c --header "Cookie: oraclelicense=accept-securebackup-cookie" https://download.oracle.com/otn-pub/java/jdk/15.0.2+7/0d1cfde4252546c6931946de8db48ee2/jdk-15.0.2_linux-x64_bin.tar.gz
            sudo mkdir /usr/lib/jvm
            cd /usr/lib/jvm
            sudo tar -xvzf ~/Downloads/jdk-15.0.2_linux-x64_bin.tar.gz
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
            echo "If your distro is based on Debian/ Fedora, report it please."
            echo "Thank you!"
            exit
        fi
    fi

    echo "Creating Desktop and Menu shortcut..."
    echo ""
    read -p "Is '$(xdg-user-dir DESKTOP)' your Desktop directory? [Y/n]" desktop
    if [ $desktop = "Y" ] || [ $desktop = "y" ]; then
        desk = $(xdg-user-dir DESKTOP)
    else
        read -p "Enter your Desktop directory?" desktop
    fi

    touch $desktop/img_of_the_day.desktop

    echo "[Desktop Entry]" >> $desktop/img_of_the_day.desktop
    echo "Version=0.1.3" >> $desktop/img_of_the_day.desktop
    echo "GenericName=Image-Of-The-Day" >> $desktop/img_of_the_day.desktop
    echo "Name=Image-Of-The-Day" >> $desktop/img_of_the_day.desktop
    echo "Categories=Application;System;Utility;Settings" >> $desktop/img_of_the_day.desktop
    echo "Exec=$(pwd)" >> $desktop/img_of_the_day.desktop
    echo "Icon=$(pwd)/src/images/Logo/logo.png" >> $desktop/img_of_the_day.desktop
    echo "Terminal=false" >> $desktop/img_of_the_day.desktop

    sudo chmod +x $desktop/img_of_the_day.desktop
    sudo cp $desktop/img_of_the_day.desktop /usr/share/applications/

    echo ""
    echo -e "Done! Desktop and Menu shortcuts created!"
    echo ""

    mkdir ~/.images


else
    echo "no!"
fi

