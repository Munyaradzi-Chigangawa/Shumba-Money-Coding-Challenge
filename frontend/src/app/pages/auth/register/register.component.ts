import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Sender } from 'src/app/models/sender';
import { SenderService } from 'src/app/services/sender.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  sender: Sender = new Sender();

  constructor(
    private senderService: SenderService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  // Add Sender
  addSender() {
    this.senderService.addSender(this.sender).subscribe(
      (response: Sender) => {
        alert("Registration successful");
        console.log(response);
        this.goToLogin();
      },
      (error: any) => console.log(error)
    );
  }

  // Go to Login
  goToLogin() {
    this.router.navigate(['/login']);
  }

  // Submit
  onSubmit() {
    console.log(this.sender);
    this.addSender();
  }
}
