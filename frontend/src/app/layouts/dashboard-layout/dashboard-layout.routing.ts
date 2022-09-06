import { Routes } from "@angular/router";
import { AddRecipientComponent } from "src/app/pages/dashboard/add-recipient/add-recipient.component";
import { RecipientComponent } from "src/app/pages/dashboard/recipient/recipient.component";
import { UpdateRecipientComponent } from "src/app/pages/dashboard/update-recipient/update-recipient.component";
import { ViewRecipientComponent } from "src/app/pages/dashboard/view-recipient/view-recipient.component";

export const DashboardLayoutRoutes: Routes = [
    {
        path: "recipient", component: RecipientComponent,
    },
    {
        path: "add-recipient", component: AddRecipientComponent,
    },
    {
        path: "view-recipient/:recipientId", component: ViewRecipientComponent,
    },
    {
        path: "update-recipient/:recipientId", component: UpdateRecipientComponent,
    }
]
