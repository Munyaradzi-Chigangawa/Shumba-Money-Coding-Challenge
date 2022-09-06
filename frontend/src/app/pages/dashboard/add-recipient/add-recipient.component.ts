import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Recipient } from 'src/app/models/recipient';
import { RecipientService } from 'src/app/services/recipient.service';

@Component({
  selector: 'app-add-recipient',
  templateUrl: './add-recipient.component.html',
  styleUrls: ['./add-recipient.component.css']
})
export class AddRecipientComponent implements OnInit {


  recipient: Recipient = new Recipient();

  constructor( private recipientService: RecipientService, private router: Router) { }

  ngOnInit(): void {
  }

  // Add Recipient
  addRecipient() {
    this.recipientService.addRecipient(this.recipient).subscribe(
      (response: Recipient) => {
        console.log(response);
        this.goToRecipientList();
      },
      (error: any) => console.log(error)
    );
  }

  goToRecipientList() {
    this.router.navigate(['/recipient']);
  }


  onSubmit() {
    console.log(this.recipient);
    this.addRecipient();
  }

}
