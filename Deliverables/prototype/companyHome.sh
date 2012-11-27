# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "---------------- IBM ------------------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display options
echo "1. Submit advert"
echo "2. Edit advert"
echo "3. Logout"
echo 
echo -n "Select option: "

# read option
read input

if [ $input == "1" ]; then
	bash ./submitAdvert.sh
elif [ $input == "2" ]; then
	bash ./editAdvert.sh
elif [ $input == "3" ]; then
	displayHeader
	echo "Logging out..."
	echo
	sleep 2
	bash ./login.sh
else
	displayHeader
	echo "Incorrect option selected."
	echo "Please try again."
	echo
	sleep 2
	bash ./companyHome.sh
fi
