# function to clear screen and display header
function displayHeader {
	clear
	echo "---------------------------------------"
	echo "-- DCS Internship Management System! --"
	echo "---------------------------------------"
	echo "------- Advert Submission Screen ------"
	echo "---------------------------------------"
	echo
}

# display header
displayHeader

# prompt for advert details
echo -n "Location: "
read location
echo -n "Description: "
read description
echo -n "Requirements: "
read requirements
echo -n "Start date: "
read startDate
echo -n "Duration: "
read duration
echo -n "Compensation: "
read compensation

# display advert
displayHeader
echo "Company: IBM"
echo "Location: " $location
echo "Description: " $description
echo "Requirements: " $requirements
echo "Start date: " $startDate
echo "Duration: " $duration
echo "Compensation: " $compensation
echo

# check if ok, if not... start again...

echo -n "Are these details correct? (y/n): "
read input

if [ $input == "y" ]; then
	echo
	echo "Submitting..."
	sleep 2
	echo "Submission successful."
	sleep 1
	bash ./companyHome.sh
else
	bash ./submitAdvert.sh
fi
