# function to clear screen and display header
function displayHeader {
	clear
	echo "------------------------------------------------------"
	echo "-- Welcome to the DCS Internship Management System! --"
	echo "------------------------------------------------------"
	echo
}

# display header
displayHeader

# login and password
echo -n "Login: " # -n allows input at the end of this line
read username
echo -n "Password: "
stty -echo
read password
stty echo
echo
echo

# check and process input
if [ $username == "tws3r" ]; then
	displayHeader
	echo "Logging in..."
	echo
	sleep 2
	#bash ./adminHome.sh
elif [ $username == "1005730w" ]; then
	displayHeader
	echo "Logging in..."
	echo	
	sleep 2
	#bash ./studentHome.sh
elif [ $username == "IBM" ]; then
	displayHeader
	echo "Logging in..."
	echo
	sleep 2
	#bash ./companyHome.sh
else
	displayHeader
	echo "Logging in..."
	echo
	sleep 2
	displayHeader
	echo "Incorrect username or password."
	echo "Please try again."
	echo
	sleep 2
	bash ./login.sh
fi