import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipient } from 'src/app/models/recipient';
import { RecipientService } from 'src/app/services/recipient.service';

@Component({
  selector: 'app-view-recipient',
  templateUrl: './view-recipient.component.html',
  styleUrls: ['./view-recipient.component.css']
})
export class ViewRecipientComponent implements OnInit {
  private recipientId!: number;
  recipient: Recipient = new Recipient();
  

  constructor(private route: ActivatedRoute, 
    private recipientService: RecipientService, private router: Router) { }

  ngOnInit(): void {
    this.recipientId = this.route.snapshot.params['recipientId'];
    this .recipientService.getRecipient(this.recipientId).subscribe(
      (data: Recipient) => {
        this.recipient = data;
      },
      (error: any) => console.log(error)
    );

    
  }
  //  logout
  onLogout() {
    alert("You have been logged out");
    localStorage.removeItem("token");
    localStorage.removeItem("senderId");
    this.router.navigate(['/login']);
  }
}
