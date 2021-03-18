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

read -p "Are you sure you want to remove Image-Of-The-Day? [Y/n]" inst
if [ $inst = "Y" ] || [ $inst = "y" ]; then
    sudo rm -rf ~/.images
    sudo rm -rf ~/.ImageOfTheDay/
    
    menu=$(which /usr/share/applications/img_of_the_day.desktop)
    if [ $menu != "" ]; then
        sudo rm /usr/share/applications/img_of_the_day.desktop
    fi

    desk=$(which $(xdg-user-dir DESKTOP)/img_of_the_day.desktop)
    if [ $desk != "" ]; then
        sudo rm $(xdg-user-dir DESKTOP)/img_of_the_day.desktop
    fi

    echo ""
    echo "Image-Of-The-Day was succesfully removed.\n Thank you."
fi