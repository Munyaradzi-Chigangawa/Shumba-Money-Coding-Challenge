import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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


  senders: Sender[] = [];
  sender: Sender = new Sender();
  
  constructor(private authService: AuthService, private senderService: SenderService,
    private router: Router
    ) { }


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
        this.router.navigate(['dash/recipient']);
      }

    }, (err: any) => {
      alert("Login failed");
      this.ngOnInit();
  })

  }

  register() {
    this.router.navigate(['/register']);
  }
}

