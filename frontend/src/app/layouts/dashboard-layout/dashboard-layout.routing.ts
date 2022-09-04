import { Routes } from "@angular/router";
import { RecipientComponent } from "src/app/pages/dashboard/recipient/recipient.component";

export const DashboardLayoutRoutes: Routes = [
    {
        path: "recipient", component: RecipientComponent
    }
]