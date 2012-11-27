# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "------------ Tom Whiteley -------------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display options
echo "1. View adverts"
echo "2. Notify course co-ordinator of successful placement"
echo "3. Logout"
echo 
echo -n "Select option: "

# read option
read input

if [ $input == "1" ]; then
	bash ./studentViewAdverts.sh
elif [ $input == "2" ]; then
	bash ./studentNotify.sh
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
	bash ./studentHome.sh
fi
