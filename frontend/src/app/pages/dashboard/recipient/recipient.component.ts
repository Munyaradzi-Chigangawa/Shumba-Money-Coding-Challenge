import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Recipient } from 'src/app/models/recipient';
import { RecipientService } from 'src/app/services/recipient.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-recipient',
  templateUrl: './recipient.component.html',
  styleUrls: ['./recipient.component.css']
})
export class RecipientComponent implements OnInit {

  recipients: Recipient[] = [];

  closeModal!: string;

  constructor(private recipientService: RecipientService, private router: Router, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getRecipients();
  }
  private getRecipients() {
    this.recipientService
      .getRecipientsList()
      .subscribe(
        (
          data: Recipient[]) => {
          this.recipients = data;
          console.log(data);
        });
  }

  // Consuming Create Endpoint
  public addRecipient(f: NgForm): void {
    this.recipientService.addRecipient(f.value).subscribe(
      (response: Recipient) => {
        console.log(response);
        this.getRecipients();
      },
      (error: any) => console.log(error)
    );
  }


  // public addRecipient(f: NgForm) {
  //   document.getElementById('add-recipient-form')?.click();
  //   this.recipientService.addRecipient(f.value).subscribe(
  //     (response: Recipient) => {
  //       console.log(response);
  //       this.getRecipients();
  //       f.reset();
  //     },
  //     (error: any) => console.log(error)
  //   );
  // }

  public updateRecipient(f: NgForm) {
    document.getElementById('update-recipient-form')?.click();
    this.recipientService.updateRecepient(f.value).subscribe(
      (response: Recipient) => {
        console.log(response);
        this.getRecipients();
        f.reset();
      },
      (error: any) => console.log(error)
    );
  }

  public deleteRecipient(recipientId: number) {
    this.recipientService.deleteRecipient(recipientId).subscribe(
      (response: void) => {
        console.log(response);
        this.getRecipients();
      },
      (error: any) => console.log(error)
    );
  }

  // onSumbit(f: NgForm) {
  //   this.addRecipient(f);
  //     this.ngOnInit();

  //   // Reload the table

  //   this.modalService.dismissAll(); // Dismiss the Modal
  // }

  open(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeModal = `Closed with: ${result}`;
    }, (reason) => {
      this.closeModal = `Dismissed ${this.getDismissalReason(reason)}`;
    })
  }

  private getDismissalReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if
      (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
