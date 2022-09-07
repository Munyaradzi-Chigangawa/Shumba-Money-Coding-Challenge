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

  // Sign In
  signIn() {
    this.authService.login(this.sender).subscribe(
      (response: any) => {
        alert("Login successful");
        console.log(response);
        this.router.navigate(['recipient']);
        localStorage.setItem("token", response.token);
      localStorage.setItem("senderId", response.senderId);
      },

      (error: any) => {
        console.log(error)
        alert("Invalid Credentials");
        this.ngOnInit();
      }

    );
  }

  register() {
    this.router.navigate(['/register']);
  }
}

