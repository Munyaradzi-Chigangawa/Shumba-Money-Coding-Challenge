import { Component, OnInit } from '@angular/core';
import { Sender } from 'src/app/models/sender';
import { AuthService } from 'src/app/services/auth.service';
import { SenderService } from 'src/app/services/sender.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  senderEmail = '';
  password = '';



  sender: Sender = new Sender();
  route: any;
  constructor(private authService: AuthService, private senderService: SenderService) { }


  ngOnInit(): void {
    this.getSenders();
  }
    public getSenders() {
      this.senderService
        .getSendersList()
        .subscribe(
          (
            data: Sender[]) => {
            this.senders = data;
            console.log(data);
          });

  }

  // Login
  login() {
    this.sender.senderEmail = this.senderEmail;
    this.sender.password = this.password;
    console.log(this.sender);

    this.authService.login(this.sender).subscribe(
      (response: any) => {
      if (response == null) {
        alert("Username or password is wrong");
        this.ngOnInit();
      } else {
        alert("Login successful");
        console.log("Login successful");
        localStorage.setItem("token", response.token);
        localStorage.setItem("senderId", response.senderId);
        this.route.navigate(['recipient']);
      }

    }, (err: any) => {
      alert("Login failed");
      this.ngOnInit();
  })

  }

  senders: Sender[] = [];
}
