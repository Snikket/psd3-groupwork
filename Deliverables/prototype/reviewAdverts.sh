# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display options
echo "1. View approved adverts"
echo "2. View pending adverts"
echo 
echo -n "Select option ('b' to go back): "

# read option
read input

if [ $input == "1" ]; then 
	bash ./approvedAdverts.sh
elif [ $input == "2" ]; then
	bash ./pendingAdverts.sh
else
	bash ./CCHome.sh
fi
