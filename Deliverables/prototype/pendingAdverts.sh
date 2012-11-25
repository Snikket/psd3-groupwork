# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "-------- Pending Adverts Screen -------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display adverts
echo "## Adverts Pending Approval ##"
echo
echo "1. IBM"
echo "   ---"
echo "   Help support and implement an internal website covering what's for"
echo "   dinner at the canteen, allowing employees to vote for what they'd like."
echo "   -----------------------------------------------------------------------"
echo "   Strong knowledge of HTML/Javascript/PHP essential."
echo "   -----------------------------------------------------------------------"
echo "   Location: Glasgow"
echo "   Start date: 06/07/2013"
echo "   Duration: 10 weeks"
echo "   Compensation: 400 per week"
echo
echo -n "Select advert to approve (b to go back): "

read input

if [ $input == "1" ]; then
	echo 
	echo "Selection: (1) IBM Glasgow"
	echo
	echo -n "Enter degree suitability (CS, ESE, SE): "
	read suitability
	echo
	echo -n "Confirm approval ('y' or 'n'): "
	read confirmation
	echo
	echo "Approving..."
	sleep 2
	echo "Approved."
	sleep 1
fi

bash ./reviewAdverts.sh
