'use client';

import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { DataTable } from '@/features/list/components/DataTable';
import useFetchList from '@/features/list/hooks/useFetchList';
import { columns } from '@/features/list/lib/columns';

export default function ListPage() {
    const { data, error } = useFetchList();

    if (data && !error) {
        return (
            <Tabs defaultValue="all">
                <TabsList>
                    <TabsTrigger value="all">All</TabsTrigger>
                    <TabsTrigger value="planning">Planning</TabsTrigger>
                    <TabsTrigger value="watching">Watching</TabsTrigger>
                    <TabsTrigger value="completed">Completed</TabsTrigger>
                </TabsList>
                <TabsContent value="all">
                    <DataTable data={data?.all ?? []} columns={columns} />
                </TabsContent>
                <TabsContent value="planning">
                    <DataTable data={data?.planning ?? []} columns={columns} />
                </TabsContent>
                <TabsContent value="watching">
                    <DataTable data={data?.watching ?? []} columns={columns} />
                </TabsContent>
                <TabsContent value="completed">
                    <DataTable data={data?.completed ?? []} columns={columns} />
                </TabsContent>
            </Tabs>
        );
    }
}
