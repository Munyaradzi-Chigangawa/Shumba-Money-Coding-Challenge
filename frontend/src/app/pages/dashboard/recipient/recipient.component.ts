import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Recipient } from 'src/app/models/recipient';
import { RecipientService } from 'src/app/services/recipient.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { filter } from 'rxjs';

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

    this.router.events.pipe(filter(event => event instanceof NavigationEnd)).subscribe(value => {
      console.log(value);
   });
  }
  public getRecipients() {
    this.recipientService.getRecipientsList()
      .subscribe(
        (
          data: Recipient[]) => {
          this.recipients = data;
          console.log(data);
        });
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