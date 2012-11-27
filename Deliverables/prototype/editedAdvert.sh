# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "-------- Edit Selection Screen --------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# display adverts
echo "## Unapproved adverts ##"
echo
echo "1.  Help support and implement an internal website covering what's for"
echo "    dinner at the canteen, allowing employees to vote for what they'd like."
echo "    -----------------------------------------------------------------------"
echo "    Strong knowledge of HTML/Javascript/PHP essential."
echo "    -----------------------------------------------------------------------"
echo "    Location: Glasgow"
echo "    Start date: 06/07/2013"
echo "    Duration: 10 weeks"
echo "    Compensation: £400 per week"
echo
echo "2.  Aid our database engineers with the mass migration of all our system"
echo "    data to lots of new databases."
echo "    --------------------------------------------------------------------"
echo "    Knowledge of SQL/MySQL preferred."
echo "    --------------------------------------------------------------------"
echo "    Location: Greenock"
echo "    Start date: 08/07/2012"
echo "    Duration: 12 weeks"
echo "    Compensation: £500"
echo
echo -n "Select advert (b to go back): "
read input

bash ./companyHome.sh
