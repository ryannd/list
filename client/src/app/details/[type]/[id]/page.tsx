import { Card, CardTitle } from '@/components/ui/card';
import fetcher from '@/lib/fetcher';
import { Media } from '@/types';

interface Params {
    id: string;
    type: string;
}

export default async function Detail({ params }: { params: Promise<Params> }) {
    const { type, id } = await params;
    const data = (await fetcher(
        `http://${process.env.NEXT_PUBLIC_API_BASE_URL}/api/details/${type}/${id}`,
    )) as Media;

    return (
        <div className="rounded-xl bg-muted/50">
            <Card>
                <CardTitle>{data.title}</CardTitle>
            </Card>
        </div>
    );
}
