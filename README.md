
# Shumba Money Coding Challenge

## Features
- Register Sender
- Sender Login
- Display Recipients
- Create Recipients
- Delete Recipients
- Update Recipients

## Tech Stack
<p align="left">
  <h3>Backend</h3> Spring Boot
    <h3>Frontend</h3> Angular
  <h3>Database</h3> MySQL

  
  ## How to Run 
  
  Clone the Repository to your local machine
  ```console  
git clone https://github.com/Munyaradzi-Chigangawa/Shumba-Money-Coding-Challenge
```

  ### Frontend
  
  To install dependencies.
```console  
npm install
```
  
Run the application. Navigate to `http://localhost:4200/`.
  ```console  
ng serve
```
  Project includes `Font Awesome Icons` so when running the app internet access is required for icons to load.
  
  ### Database 
  Start your `MySQL Server` or `XAMPP`
  
  ### Backend
  Open the project with `IntelliJ Idea`.
  <br> 
  Allow packages and dependencies to be installed
  `Run the Application`.
  Take note that the port opened is running on `:8080`
  
  ### API Endpoints
  ```
  private baseUrl = 'http://localhost:8080/api/v1';
  
  ```
  
  Read All Recipients
  ```
  ${this.baseUrl}/getRecipients?senderId=${localStorage.getItem("senderId")}
  ```
  
  Add Recipient
  ```
  ${this.baseUrl}/addRecipient?senderId=${localStorage.getItem("senderId")}
  ```
  
  ``` JSON
  {
    "recipientName": "Munya",
    "recipientEmail": "munyaradzichigangawa@gmail.com",
    "recipientAddress": "9801 Ruvimbo 2, Chinhoyi",
    "recipientCell": "+263772288925",
    "recipientCountry": "Zimbabwe",
    "recipientTown": "Chinhoyi"
}
```
  
  Update Recipient
 ```
 ${this.baseUrl}/updateRecipient/${recipientId}?senderId=${localStorage.getItem("senderId")}
 ```
 
 Delete Recipient
 ```
 ${this.baseUrl}/deleteRecipient/${recipientId}
 ```
 
## Preview
`Create Account`
![Screenshot (67)](https://user-images.githubusercontent.com/56768581/188908611-742af187-8eb4-47b8-b842-4047e37db06a.png)

 
 
  
 
