'use client';

import { Entry } from '@/features/list/types';
import { ColumnDef } from '@tanstack/react-table';

export const columns: ColumnDef<Entry>[] = [
    {
        accessorKey: 'media.title',
        header: 'Title',
    },
    {
        accessorKey: 'status',
        header: 'Status',
    },
    {
        accessorKey: 'media.type',
        header: 'Type',
    },
    {
        accessorKey: 'episodeProgress',
        header: 'Progress',
    },
    {
        accessorKey: 'rating',
        header: 'Rating',
    },
];
