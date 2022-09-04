import { Component, OnInit } from '@angular/core';
import { Sender } from 'src/app/models/sender';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = '';
  password = '';



  sender: Sender = new Sender();
  route: any;
  constructor() { }
  

  ngOnInit(): void {

  }

  login() {
    this.sender.senderEmail = this.email;
    this.sender.password = this.password;
    console.log(this.sender);
  }


}
