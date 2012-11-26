# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "---------- View Advert Screen ---------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display adverts
echo "1.  IBM"
echo "    ---"
echo "    Help support and implement an internal website covering what's for"
echo "    dinner at the canteen, allowing employees to vote for what they'd like."
echo "    -----------------------------------------------------------------------"
echo "    Strong knowledge of HTML/Javascript/PHP essential."
echo "    -----------------------------------------------------------------------"
echo "    Location: Glasgow"
echo "    Start date: 06/07/2013"
echo "    Duration: 10 weeks"
echo "    Compensation: £400 per week"
echo "    Suitable for: CS/SE"
echo
echo
echo "2.  PVT Electronics"
echo "    ---------------"
echo "    Help implement a flight tracking system for auto-piloting model"
echo "    aircraft. To be used for logging relative visibility levels at height."
echo "    ----------------------------------------------------------------------"
echo "    Knowledge of Python/Perl required. Autpilot systems desirable."
echo "    --------------------------------------------------------------------"
echo "    Location: Greenock"
echo "    Start date: 08/07/2013"
echo "    Duration: 12 weeks"
echo "    Compensation: £600 per month"
echo "    Suitable for: CS/SE/ESE"
echo
echo
echo "3.  Amazon"
echo "    ------"
echo "    Aid the advert team in making lots of adverts that auto-customise so"
echo "    the adverts are more appealing to customers who otherwise hate adverts."
echo "    -----------------------------------------------------------------------"
echo "    Knowledge and a passion for advertising and adverts essential."
echo "    --------------------------------------------------------------------"
echo "    Location: Edinburgh"
echo "    Start date: 10/07/2013"
echo "    Duration: 11 weeks"
echo "    Compensation: £1100 per day"
echo "    Suitable for: CS/SE"
echo

# display options
echo "1. Apply"
echo "2. Go back"
echo
echo -n "Select option: "

# read option
read input

if [ $input == "1" ]; then
	echo
	echo "Browser automatically opens company's URL for applying..."
	sleep 2
	bash ./studentHome.sh
else
	bash ./studentHome.sh
fi
