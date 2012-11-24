# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo
}

#display header
displayHeader

#display options
echo "1. Submit advert to system"
echo "2. Edit submitted advert"
echo "3. Logout"
echo 
echo -n "Select option: "

# read option
read input

if [ $input == "1" ]; then 
	echo "Submit advert!"
	sleep 2
	#bash ./submitAdvert.sh
elif [ $input == "2" ]; then
	echo "Edit advert!"
	sleep 2
	#bash ./editAdvert.sh
elif [ $input == "3" ]; then
	displayHeader
	echo "Logging out..."
	echo
	sleep 2
	bash ./login.sh
else
	displayHeader
	echo "Incorrect option selected, please try again."
	echo
	sleep 2
	bash ./companyHome.sh
fi
