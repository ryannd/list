'use client';

import { DataTable } from '@/features/list/components/DataTable';
import useFetchList from '@/features/list/hooks/useFetchList';
import { columns } from '@/features/list/lib/columns';

export default function ListPage() {
    const { data, error } = useFetchList();

    if (data && !error) {
        return (
            <>
                <DataTable data={data?.all ?? []} columns={columns} />
            </>
        );
    }
}
