

import java.text.SimpleDateFormat;

public class RescueAnimal {

    // Instance variables
    private String name;
    private String type;
    private String gender;
    private int age;
    private float weight;
    private SimpleDateFormat acquisitionDate;
    private SimpleDateFormat statusDate;
    private String acquisitionSource;
    private Boolean reserved;

    private String trainingLocation;
    private SimpleDateFormat trainingStart;
    private SimpleDateFormat trainingEnd;
    private String trainingStatus;

    private String inServiceCountry;
    private String inServiceCity;
    private String inServiceAgency;
    private String inServicePOC;
    private String inServiceEmail;
    private String inServicePhone;
    private String inServicePostalAddress;

    // Constructor
    public RescueAnimal() {
    }

    // Add Accessor Methods here
    public String getName() {
    	return this.name;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public String getGender() {
    	return this.gender;
    }
    
    public int getAge() {
    	return this.age;
    }
    
    public float getWeight() {
    	return this.weight;
    }
    
    public SimpleDateFormat getAcquisitionDate() {
    	return this.acquisitionDate;
    }
    
    public SimpleDateFormat getStatusDate() {
    	return this.statusDate;
    }
    
    public String getAcquisitionSource() {
    	return this.acquisitionSource;
    }
    
    public Boolean isReserved() {
    	return this.reserved;
    }
    
    public String getTrainingLocation() {
    	return this.trainingLocation;
    }
    
    public SimpleDateFormat getTrainingStart() {
    	return this.trainingStart;
    }
    
    public SimpleDateFormat getTrainingEnd() {
    	return this.trainingEnd;
    }
    /**
     * Returns the training status of the animal. It is one of the following:
     * <ul>
     *   <li> Intake - New Animal</li>
     *   <li> Phase I </li>
     *   <li> Phase II </li>
     *   <li> Phase III </li>
     *   <li> Phase IV </li>
     *   <li> Phase V </li>
     *   <li> In Service - Graduated from service academy </li>
     *   <li> Farm - Fails the academy and is retired on the farm </li>
     * </ul>
     * @return status
     */
    public String getTrainingStatus() {
    	return this.trainingStatus;
    }
    
    /**
     * Returns the country the animal is serving in. One of the following:
     * <ul>
     *   <li> Chile </li>
     *   <li> Greece </li>
     *   <li> Japan </li>
     *   <li> Madagascar </li>
     *   <li> Singapore </li>
     *   <li> South Korea </li>
     *   <li> Turkey </li>
     *   <li> United Kingdom </li>
     *   <li> United States </li>
     * </ul>
     * @return country
     */
    public String getServiceCountry() {
    	return this.inServiceCountry;
    }

    public String getServiceCity() {
    	return this.inServiceCity;
    }
    
    public String getServiceAgency() {
    	return this.inServiceAgency;
    }
    
    public String getServicePOC() {
    	return this.inServicePOC;
    }
    
    public String getServiceEmail() {
    	return this.inServiceEmail;
    }
    
    public String getServicePhone() {
    	return this.inServicePhone;
    }
    
    public String getServicePostalAddress() {
    	return this.inServicePostalAddress;
    }

    // Add Mutator Methods here
    
    public void setName(String name) {
    	if(!name.isEmpty()) {
    		this.name = name;
    	}
    	else {
    		throw new Error("Name cannot be empty.");
    	}
    }
    
    public void setType(String type) {
    	if(!type.isEmpty()) {
    		this.type = type;
    	}
    	else {
    		throw new Error("Type cannot be empty.");
    	}
    }

    public void setGender(String gender) {
    	if(!gender.isEmpty()) {
    		// guarantee we only use the two sexes for the animals
    		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
    			this.gender = gender;
    		}
    		else {
    			throw new Error("Sex must be male or female.");
    		}
    		
    	}
    	else {
    		throw new Error("Gender cannot be empty.");
    	}
    }
    
    public void setAge(int age) {
    	if(age > 0) {
    		this.age = age;
    	}
    	else {
    		throw new Error("Age must be greate than 0.");
    	}
    }
    
    public void setWeight(float weight) {
    	if(weight > 0) {
    		this.weight = weight;
    	}
    	else {
    		throw new Error("Weight must be greater than 0.");
    	}
    }
    
    public void setAcquisitionDate(SimpleDateFormat date) {
    	this.acquisitionDate = date;
    }
    
    public void setStatusDate(SimpleDateFormat date) {
    	this.statusDate = date;
    }
    
    public void setAcquisitionSource(String source) {
    	this.acquisitionSource = source;
    }
    
    public void setReserved(Boolean reserved) {
    	this.reserved = reserved;
    }
    
    public void setTrainingLocation(String trainingLocation) {
    	if(!trainingLocation.isEmpty()) {
    		this.trainingLocation = trainingLocation;
    	}
    	else {
    		throw new Error("Training Location cannot be empty.");
    	}
    }

    public void setTrainingStart(SimpleDateFormat start) {
    	this.trainingStart = start;
    }
    
    public void setTrainingEnd(SimpleDateFormat end) {
    	this.trainingEnd = end;
    }
    
    public void setTrainingStatus(String status) {
    	if(status.isEmpty()) {
    		throw new Error("Status cannot be empty.");
    	}
    	else {
    		// cannot use switch(String) in openjdk1.8
    		if(status.equalsIgnoreCase("Phase I")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Phase I")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Phase II")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Phase III")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Phase IV")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Phase V")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Service")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("In Service")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Farm")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Deceased")) {
    			this.trainingStatus = status;
    		} else if(status.equalsIgnoreCase("Intake")) {
    			this.trainingStatus = status;
    		} else {
    			throw new Error("Invalid status.");
    		}

//    		switch(status) {
//    			case "Phase I":
//    			case "Phase II":
//    			case "Phase III":
//    			case "Phase IV":
//    			case "Phase V":
//    			case "Service":
//    			case "In Service":
//    			case "Farm":
//    			case "Deceased":
//    				this.trainingStatus = status; break;
//    			default:
//    				throw new Error("Invalid status.");
//    		}	
    	}
    }
    
    public void setServiceCountry(String country) {
    	if(!country.isEmpty()) {
    		this.inServiceCountry = country;
    	}
    	else {
    		throw new Error("Service country cannot be empty.");
    	}
    }

    public void setServiceCity(String city) {
    	if(!city.isEmpty()) {
    		this.inServiceCity = city;
    	}
    	else {
    		throw new Error("Service city cannot be empty.");
    	}
    }
    
    public void setServiceAgency(String agency) {
    	if(!agency.isEmpty()) {
    		this.inServiceAgency = agency;
    	}
    	else {
    		throw new Error("Service Agency cannot be empty.");
    	}
    }
    
    public void setServicePOC(String poc) {
    	if(!poc.isEmpty()) {
    		this.inServicePOC = poc;
    	}
    	else {
    		throw new Error("POC cannot be empty.");
    	}
    }
    
    public void setServiceEmail(String email) {
    	if(!email.isEmpty()) {
    		this.inServiceEmail = email;
    	}
    	else {
    		throw new Error("Service email cannot be empty.");
    	}
    }
    
    public void setServicePhone(String phone) {
    	if(!phone.isEmpty()) {
    		this.inServicePhone= phone;
    	}
    	else {
    		throw new Error("Service Phone number cannot be empty.");
    	}
    }
    
    public void setServicePostalAddress(String address) {
    	if(!address.isEmpty()) {
    		this.inServicePostalAddress = address;
    	}
    	else {
    		throw new Error("Service address cannot be empty.");
    	}
    }

}
