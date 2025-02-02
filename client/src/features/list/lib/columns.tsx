"use client"

import { Entry } from "@/features/list/types"
import { ColumnDef } from "@tanstack/react-table"

export const columns: ColumnDef<Entry>[] = [
    {
        accessorKey: "title",
        header: "Title"
    },
    {
        accessorKey: "status",
        header: "Status"
    },
    {
        accessorKey: "episodeProgress",
        header: "Progress"
    },
    {
        accessorKey: "rating",
        header: "Rating"
    }
]